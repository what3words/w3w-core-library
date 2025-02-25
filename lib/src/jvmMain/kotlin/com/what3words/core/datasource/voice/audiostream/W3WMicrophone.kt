package com.what3words.core.datasource.voice.audiostream

/**
 * Platform-specific implementation of [W3WAudioStream] interface, facilitating connection with the device
 * audio framework to capture and process audio signals from the device's microphone.
 */
actual class W3WMicrophone : W3WAudioStream(){
    actual override var config: W3WAudioStreamConfig
        get() = TODO("Not yet implemented")
        set(value) {}

    actual override fun openAudioInputStream(onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit) {
        TODO("Not yet implemented")
    }

    actual override fun closeAudioInputStream() {
        TODO("Not yet implemented")
    }

    actual override fun updateConfig(config: W3WAudioStreamConfig): W3WAudioStream {
        TODO("Not yet implemented")
    }

    actual override fun setEventsListener(listener: EventsListener): W3WAudioStream {
        TODO("Not yet implemented")
    }

}