package com.what3words.core.datasource.voice.audiostream

/**
 * Platform-specific implementation of [W3WAudioStream] interface, facilitating connection with the device
 * audio framework to capture and process audio signals from the device's microphone.
 */
expect class W3WMicrophone : W3WAudioStream {
    override var config: W3WAudioStreamConfig
    override fun closeAudioInputStream()
    override fun openAudioInputStream(onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit)
    override fun setEventsListener(listener: EventsListener): W3WAudioStream
    override fun updateConfig(config: W3WAudioStreamConfig): W3WAudioStream
}
