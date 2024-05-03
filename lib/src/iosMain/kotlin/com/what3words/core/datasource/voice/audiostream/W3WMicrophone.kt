package com.what3words.core.datasource.voice.audiostream

import com.what3words.core.datasource.voice.audiostream.util.AudioSignalAmplitudeProcessor
import com.what3words.core.types.common.W3WError
import com.what3words.core.datasource.voice.audiostream.W3WAudioStream.EventsListener
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointerVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.withContext
import platform.AVFAudio.AVAudioCommonFormat
import platform.AVFAudio.AVAudioConverter
import platform.AVFAudio.AVAudioEngine
import platform.AVFAudio.AVAudioFormat
import platform.AVFAudio.AVAudioInputNode
import platform.AVFAudio.AVAudioPCMBuffer
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryRecord
import platform.AVFAudio.AVAudioTime
import platform.AVFAudio.setActive
import platform.AVFAudio.setPreferredSampleRate
import platform.posix.int16_tVar
import kotlin.math.PI

/**
 * IOS implementation of the microphone audio stream, providing methods to interact with the device audio framework.
 * Manages configuration, opening, and closing of the audio stream, as well as processing of audio signals.
 */
actual class W3WMicrophone(
    override var config: W3WAudioStreamConfig = W3WMicrophone.defaultConfig()
) : W3WAudioStream() {

    /**
     * Listener to communicate events from this audio stream instance to the client
     */
    private var eventsListener: EventsListener? = null

    /**
     * Audio engine responsible for managing audio processing tasks.
     */
    private lateinit var audioEngine: AVAudioEngine

    /**
     * Input node for capturing audio input from the microphone.
     */
    private lateinit var mic: AVAudioInputNode

    /**
     * Flag indicating whether the audio stream is currently listening for audio signals.
     * Initialized as false and updated during the audio stream lifecycle.
     */
    private var listening: Boolean = false

    /**
     * Semaphore for controlling access to the audio buffer during processing.
     * Ensures synchronized access to the audio data processing procedure.
     */
    private var audioBufferControlSemaphore: Semaphore = Semaphore(1)

    /**
     * Configures the audio session for microphone input.
     * Initializes the audio engine, input node, and sets the preferred sample rate.
     * If an error occurs during initialization, it notifies the listener and closes the audio input stream.
     */
    @OptIn(ExperimentalForeignApi::class)
    private fun configureAudioSession() {
        try {
            audioEngine = AVAudioEngine()
            mic = audioEngine.inputNode()

            AVAudioSession.sharedInstance()
                .setCategory(category = AVAudioSessionCategoryRecord, error = null)
            AVAudioSession.sharedInstance().setActive(active = true, error = null)
            AVAudioSession.sharedInstance()
                .setPreferredSampleRate(sampleRate = config.sampleRateInHz.toDouble(), null)
        } catch (e: Exception) {
            CoroutineScope(Dispatchers.Main).launch {
                eventsListener?.onError(
                    W3WError(
                        message = "Microphone initialization error. Cause:$e",
                        cause = e
                    )
                )
            }
            closeAudioInputStream()
        }
    }

    /**
     * Starts listening to audio signals from the microphone input.
     * Configures the output format, sets up audio converter, and installs a tap on the microphone input.
     * When audio signals are received, they are converted, processed, and provided to the client via the provided callback.
     * If already listening, this method takes no action.
     *
     * @param onAudioSignal Callback function to handle incoming audio signals.
     */
    @OptIn(ExperimentalForeignApi::class)
    private fun startMicrophone(onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit) {
        // Define the output format for the audio
        val outputFormat = AVAudioFormat(
            commonFormat = config.encoding.value as AVAudioCommonFormat,
            sampleRate = config.sampleRateInHz.toDouble(),
            channels = 1u,
            interleaved = false
        )

        // Obtain the input format for the microphone input node
        val micFormat = mic.inputFormatForBus(bus = 0u)

        // Create an audio converter to convert microphone input to desired output format
        val converter = AVAudioConverter(fromFormat = micFormat, toFormat = outputFormat)

        // Start listening only if not already listening
        if (!listening) {
            listening = true
            CoroutineScope(Dispatchers.Main).launch {
                eventsListener?.onAudioStreamStateChange(state = W3WAudioStreamState.LISTENING)
            }

            // Install a tap on the microphone input to receive audio signals
            mic.installTapOnBus(
                bus = 0u,
                bufferSize = config.samplesPerChannel.toUInt(),
                format = micFormat
            ) { avAudioPCMBuffer: AVAudioPCMBuffer?, avAudioTime: AVAudioTime? ->
                if (avAudioPCMBuffer != null && avAudioTime != null) {
                    // Asynchronously process the received audio buffer
                    CoroutineScope(Dispatchers.IO).launch {
                        // Acquire access to critical section of code
                        audioBufferControlSemaphore.acquire()

                        // Create a buffer to hold the converted audio data
                        val convertedBuffer = AVAudioPCMBuffer(
                            pCMFormat = outputFormat,
                            frameCapacity = outputFormat.sampleRate.toUInt() * avAudioPCMBuffer.frameLength / avAudioPCMBuffer.format.sampleRate.toUInt()
                        )

                        // Convert the audio buffer to the desired output format
                        val conversionStatus = converter.convertToBuffer(
                            outputBuffer = convertedBuffer,
                            fromBuffer = avAudioPCMBuffer,
                            error = null
                        )

                        // If conversion successful, process and provide the audio signal to the client
                        if (conversionStatus) {
                            val audioData =
                                extractAVAudioSignal(buffer = convertedBuffer)
                            onAudioSignal(audioData.size, audioData)
                            computeVolumeChange(audioData = audioData)
                        }

                        // Release semaphore after processing the audio buffer
                        audioBufferControlSemaphore.release()
                    }
                }
            }
        }
    }

    /**
     * Computes the volume change based on the provided audio data.
     *
     * @param audioData The audio data from which to calculate the volume change.
     */
    private suspend fun computeVolumeChange(audioData: ShortArray) {
        // Calculate the volume from the audio data
        val rawVolume =
            AudioSignalAmplitudeProcessor.calculateVolume(audioData.size, audioData)
        // Transform the raw volume into a scaled factor between 0.0 and 1.0
        val scaledVolume = AudioSignalAmplitudeProcessor.scaleVolume(rawVolume)
        // Notify the listener about the volume change
        withContext(Dispatchers.Main) {
            eventsListener?.onVolumeChange(scaledVolume)
        }
    }

    /**
     * Extracts audio signal from the given AVAudioPCMBuffer based on the specified encoding format.
     *
     * @param buffer The AVAudioPCMBuffer containing the audio signal.
     * @return A ShortArray representing the extracted audio signal.
     */
    @OptIn(ExperimentalForeignApi::class)
    private fun extractAVAudioSignal(buffer: AVAudioPCMBuffer): ShortArray {
        /**
         * Converts the audio data in the first float channel of an [AVAudioPCMBuffer] to a ShortArray.
         *
         * @param floatChannelData The float channel data to be processed.
         * @return A ShortArray representing the converted audio data.
         */
        @OptIn(ExperimentalForeignApi::class)
        fun convertFloatChannelData(floatChannelData: CPointer<CPointerVar<FloatVar>>?): ShortArray {
            if (floatChannelData == null) return shortArrayOf()
            val frameLength = buffer.frameLength.toInt()
            val audioData = ShortArray(frameLength)
            val channelData = floatChannelData[0] ?: return shortArrayOf()

            // Maximum value for signed 16-bit integer
            val int16MaxValue = 32768
            // Scaling factor for the conversion from float to a 16-bit integer
            val scalingFactor = 2.0

            // Iterate through each frame of the audio data and perform the conversion from float to Int16
            for (frame in 0 until frameLength) {
                var convertedToInt16: Short = 0
                val sample = channelData[frame] * int16MaxValue / (scalingFactor * PI)
                // Check if the converted sample is within the range of Int16
                if (sample > Short.MIN_VALUE.toFloat() && sample < Short.MAX_VALUE.toFloat()) {
                    convertedToInt16 =
                        (frame * int16MaxValue / (scalingFactor * PI)).toInt().toShort()
                }
                audioData[frame] = convertedToInt16
            }
            return audioData
        }


        /**
         * Converts the audio data in the first 16-bit integer channel of an [AVAudioPCMBuffer] to a ShortArray.
         *
         * @param int16ChannelData The 16-bit integer channel data to be processed.
         * @return A ShortArray representing the converted audio data.
         */
        @OptIn(ExperimentalForeignApi::class)
        fun convertInt16ChannelData(int16ChannelData: CPointer<CPointerVar<int16_tVar>>?): ShortArray {
            if (int16ChannelData == null) return shortArrayOf()
            val frameLength = buffer.frameLength.toInt()
            val audioData = ShortArray(frameLength)
            val channelData = int16ChannelData[0] ?: return shortArrayOf()
            for (frame in 0 until frameLength) {
                // Retrieve the Int16 value from the channel's buffer and convert it to Short
                audioData[frame] = channelData[frame].toShort()
            }

            return audioData
        }

        // Determine the encoding format and call the appropriate conversion function
        return when (config.encoding) {
            W3WIOSAudioStreamEncoding.PCM_S16LE -> {
                convertInt16ChannelData(int16ChannelData = buffer.int16ChannelData)
            }

            W3WIOSAudioStreamEncoding.PCM_F32LE -> {
                convertFloatChannelData(floatChannelData = buffer.floatChannelData)
            }

            else -> shortArrayOf()
        }
    }

    /**
     * Opens the audio stream and begins listening for audio signals to process.
     *
     * @param onAudioSignal Callback invoked when the [W3WAudioStream] receives new audio data.
     */
    override fun openAudioInputStream(onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit) {
        configureAudioSession()
        startMicrophone(onAudioSignal)
    }

    /**
     * Deactivates the [AVAudioSession], stops the [AVAudioEngine] and release system resources.
     */
    @OptIn(ExperimentalForeignApi::class)
    override fun closeAudioInputStream() {
        try {
            AVAudioSession.sharedInstance().setActive(active = false, error = null)
            audioEngine.stop()
            audioEngine.reset()
            if (listening) {
                listening = false
                mic.removeTapOnBus(bus = 0u)
                CoroutineScope(Dispatchers.Main).launch {
                    eventsListener?.onAudioStreamStateChange(state = W3WAudioStreamState.STOPPED)
                }
                if (audioBufferControlSemaphore.availablePermits > 0) audioBufferControlSemaphore.release()
            }
        } catch (e: Throwable) {
            CoroutineScope(Dispatchers.Main).launch {
                eventsListener?.onError(
                    error = W3WError(
                        message = "Error deactivating audio session. Cause:$e",
                        cause = e
                    )
                )
            }
        }
    }

    /**
     * Updates the configuration used to create the audio stream.
     *
     * @param config The updated configuration.
     * @return The updated [W3WAudioStream].
     */
    override fun updateConfig(config: W3WAudioStreamConfig): W3WAudioStream {
        this.config = config
        return this
    }

    /**
     * Sets an [EventsListener] to receive events from the [W3WAudioStream].
     *
     * @param listener The listener to set.
     * @return The [W3WAudioStream] instance with the events listener set.
     */
    override fun setEventsListener(listener: EventsListener): W3WAudioStream {
        this.eventsListener = listener
        return this
    }


    companion object {
        /**
         * Provides the default configuration for a [W3WAudioStream].
         * This configuration includes a sample rate of 44100 Hz, 2048 samples per channel,
         * and PCM_S16LE encoding.
         *
         * @return The default W3WAudioStreamConfig.
         */
        fun defaultConfig(): W3WAudioStreamConfig = W3WAudioStreamConfig(
            sampleRateInHz = 44100,
            samplesPerChannel = 2048,
            encoding = W3WIOSAudioStreamEncoding.PCM_S16LE
        )
    }

}