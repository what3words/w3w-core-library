package com.what3words.core.datasource.voice.audiostream

/**
 * Enum class representing the states of a [W3WAudioStream].
 * Each state indicates the current operational status of the audio stream.
 */
enum class W3WAudioStreamState {
    /**
     * The audio stream has started listening for audio signals.
     */
    LISTENING,

    /**
     * The audio stream has stopped listening for audio signals and closed input.
     */
    STOPPED
}