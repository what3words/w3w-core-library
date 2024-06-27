package com.what3words.core.datasource.voice.audiostream

/**
 * Interface defining the platform-specific representation of supported audio stream encodings.
 *
 * Audio encoding describes the format used to represent audio data, which can vary depending on the platform.
 * It encompasses both uncompressed formats like linear PCM and compressed formats such as AC3 or DTS.
 *
 * The value property represents the specific encoding value relevant to the platform.
 */
interface W3WAudioStreamEncoding {
    /** The platform-specific value representing the audio stream encoding. */
    val value: Any
}