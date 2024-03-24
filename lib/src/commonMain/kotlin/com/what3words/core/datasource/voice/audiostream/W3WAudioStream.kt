package com.what3words.core.datasource.voice.audiostream

import com.what3words.core.types.common.W3WError
import com.what3words.core.datasource.voice.W3WVoiceDatasource

/**
 * Abstract class defining the contract for all audio streams that can be utilized by [W3WVoiceDatasource]
 * to facilitate an autosuggest request.
 */
abstract class W3WAudioStream {
    /**
     * Configuration for the audio stream.
     */
    internal abstract var config: W3WAudioStreamConfig

    /**
     * Opens the audio stream and begins listening for audio signals to process.
     *
     * @param onAudioSignal Callback invoked when the [W3WAudioStream] receives new audio data.
     */
    internal abstract fun openAudioInputStream(onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit)

    /**
     * Instructs the audio stream to cease listening for new audio signals and release system resources.
     */
    internal abstract fun closeAudioInputStream()

    /**
     * Updates the configuration used to create the audio stream.
     *
     * @param config The updated configuration.
     * @return The updated [W3WAudioStream].
     */
    abstract fun updateConfig(config: W3WAudioStreamConfig): W3WAudioStream

    /**
     * Sets an [EventsListener] to receive events from the [W3WAudioStream].
     *
     * @param listener The listener to set.
     * @return The [W3WAudioStream] instance with the events listener set.
     */
    abstract fun setEventsListener(listener: EventsListener): W3WAudioStream

    /**
     * Interface to handle events occurring within the [W3WAudioStream].
     */
    interface EventsListener {
        /** Event triggered when the state of the [W3WAudioStream] changes. */
        fun onAudioStreamStateChange(state: W3WAudioStreamState) {}

        /** Event triggered when there's a change in volume, where volume is in the range 0.0 - 1.0. */
        fun onVolumeChange(volume: Float) {}

        /** Event triggered when the [W3WAudioStream] encounters an error. */
        fun onError(error: W3WError) {}
    }
}