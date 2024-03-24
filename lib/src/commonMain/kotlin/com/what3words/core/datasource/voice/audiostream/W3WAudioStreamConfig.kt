package com.what3words.core.datasource.voice.audiostream

/**
 * Data class representing the configuration settings for a [W3WAudioStream].
 *
 * @property sampleRateInHz The sample rate for the audio stream, expressed in Hertz.
 * @property samplesPerChannel The number of audio samples returned in each channel of the audio stream.
 * @property encoding Describes the bit representation of the samples in the audio signal.
 */
data class W3WAudioStreamConfig(
    val sampleRateInHz: Int,
    val samplesPerChannel: Int,
    val encoding: W3WAudioStreamEncoding
)