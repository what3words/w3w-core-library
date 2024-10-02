package com.what3words.core.datasource.voice.audiostream

import android.annotation.SuppressLint
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.util.Log
import com.what3words.core.datasource.voice.audiostream.util.AudioSignalAmplitudeProcessor
import com.what3words.core.types.common.W3WError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Android implementation of the [W3WMicrophone] audio stream.
 * **/
actual class W3WMicrophone(
    actual override var config: W3WAudioStreamConfig = W3WMicrophone.defaultConfig()
) : W3WAudioStream() {

    // Represents the audio source for recording
    private val audioSource: Int = MediaRecorder.AudioSource.MIC

    // Represents the AudioRecord instance used for recording audio
    private var recorder: AudioRecord? = null

    /**
     * Listener to communicate events from this audio stream instance to the client
     */
    private var eventsListener: EventsListener? = null

    /**
     * Flag indicating whether the audio stream is currently listening for audio signals.
     * Initialized as false and updated during the audio stream lifecycle.
     */
    private var isListening: Boolean = false

    /**
     * Opens the audio stream and begins listening for audio signals to process.
     *
     * @param onAudioSignal Callback invoked when the [W3WAudioStream] receives new audio data.
     */
    @SuppressLint("MissingPermission")
    actual override fun openAudioInputStream(onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit) {
        if (!isSampleRateValid(config.sampleRateInHz)) {
            CoroutineScope(Dispatchers.Main).launch {
                eventsListener?.onError(
                    W3WError("Invalid sample rate, please use one of the following: ${getSupportedSampleRates().joinToString { it.toString() }}")
                )
            }
            return
        }

        // Initialize AudioRecord instance with specified configuration
        recorder = AudioRecord(
            audioSource,
            config.sampleRateInHz,
            AudioFormat.CHANNEL_IN_MONO,
            config.encoding.value as Int,
            config.samplesPerChannel
        ).also { audioRecord ->
            if (audioRecord.state == AudioRecord.STATE_INITIALIZED) {
                isListening = true
                CoroutineScope(Dispatchers.IO).launch {
                    withContext(Dispatchers.Main) {
                        eventsListener?.onAudioStreamStateChange(
                            W3WAudioStreamState.LISTENING
                        )
                    }
                    val buffer = ShortArray(config.samplesPerChannel)
                    var oldTimestamp = System.currentTimeMillis()
                    audioRecord.startRecording()
                    while (isListening) {
                        val readCount = audioRecord.read(buffer, 0, buffer.size)
                        onAudioSignal(readCount, buffer)
                        if ((System.currentTimeMillis() - oldTimestamp) > 100) {
                            oldTimestamp = System.currentTimeMillis()
                            // Calculate the volume from the audio data
                            val rawVolume =
                                AudioSignalAmplitudeProcessor.calculateVolume(readCount, buffer)
                            // Transform the raw volume into a scaled factor between 0.0 and 1.0
                            val scaledVolume = AudioSignalAmplitudeProcessor.scaleVolume(rawVolume)
                            // Notify the listener about the volume change
                            withContext(Dispatchers.Main) {
                                eventsListener?.onVolumeChange(volume = scaledVolume)
                            }
                        }
                    }
                }
            } else {
                Log.e(
                    "VoiceFlow",
                    "Failed to initialize AudioRecord, please request AUDIO_RECORD permission."
                )
                CoroutineScope(Dispatchers.Main).launch {
                    eventsListener?.onError(
                        W3WError(
                            "Failed to initialize AudioRecord, please request AUDIO_RECORD permission."
                        )
                    )
                }
            }
        }
    }

    /**
     * Deactivates the audio session and release system resources.
     */
    actual override fun closeAudioInputStream() {
        isListening = false
        CoroutineScope(Dispatchers.Main).launch {
            eventsListener?.onAudioStreamStateChange(
                W3WAudioStreamState.STOPPED
            )
        }
        recorder?.release()
    }

    /**
     * Updates the configuration used to create the audio stream.
     *
     * @param config The updated configuration.
     * @return The updated [W3WAudioStream].
     */
    actual override fun updateConfig(config: W3WAudioStreamConfig): W3WAudioStream {
        this.config = config
        return this
    }

    /**
     * Sets an [EventsListener] to receive events from the [W3WAudioStream].
     *
     * @param listener The listener to set.
     * @return The [W3WAudioStream] instance with the events listener set.
     */
    actual override fun setEventsListener(listener: EventsListener): W3WAudioStream {
        this.eventsListener = listener
        return this
    }

    companion object {
        private const val DEFAULT_RECORDING_RATE = 44100

        /**
         * Retrieves the optimal sample rate based on the preferred sample rate.
         * If the preferred sample rate is valid, it is returned as the optimal rate.
         * Otherwise, the maximum supported sample rate is returned.
         * @param preferredSampleRate The preferred sample rate to consider.
         *
         * @return The optimal sample rate.
         */
        fun getOptimalSampleRate(preferredSampleRate: Int): Int {
            return if (isSampleRateValid(preferredSampleRate)) {
                preferredSampleRate
            } else {
                getSupportedSampleRates().maxOrNull() ?: -1
            }
        }

        /**
         * Checks if the provided sample rate is valid or supported.
         *
         * @param sampleRate The sample rate to validate.
         * @return `true` if the sample rate is valid, `false` otherwise.
         */
        fun isSampleRateValid(sampleRate: Int): Boolean {
            return getSupportedSampleRates().contains(sampleRate)
        }

        /**
         * Retrieves a list of supported sample rates for audio recording.
         *
         * @return A list of supported sample rates.
         */
        fun getSupportedSampleRates(): List<Int> {
            val validSampleRates = intArrayOf(
                8000, 11025, 16000, 22050, 44100, 48000
            )
            val list = mutableListOf<Int>()
            validSampleRates.forEach {
                val result = AudioRecord.getMinBufferSize(
                    it,
                    AudioFormat.CHANNEL_IN_DEFAULT,
                    AudioFormat.ENCODING_PCM_16BIT
                )
                if (result != AudioRecord.ERROR && result != AudioRecord.ERROR_BAD_VALUE && result > 0) {
                    list.add(it)
                }
            }
            return list
        }

        fun defaultConfig(): W3WAudioStreamConfig {
            return W3WAudioStreamConfig(
                sampleRateInHz = DEFAULT_RECORDING_RATE,
                samplesPerChannel = AudioRecord.getMinBufferSize(
                    DEFAULT_RECORDING_RATE,
                    AudioFormat.CHANNEL_IN_DEFAULT,
                    W3WAndroidAudioStreamEncoding.PCM_16BIT.value as Int
                ),
                encoding = W3WAndroidAudioStreamEncoding.PCM_16BIT
            )
        }
    }
}