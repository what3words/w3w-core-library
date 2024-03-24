package com.what3words.core.datasource.voice.audiostream.util

import kotlin.math.log10

/**
 * Utility object for processing audio signal amplitudes/volume.
 */
object AudioSignalAmplitudeProcessor {

    // Constants defining the minimum and maximum signal levels
    private const val MIN_SIGNAL_LEVEL = 20
    private const val MAX_SIGNAL_LEVEL = 80

    // Constants defining the minimum and maximum scaled levels
    private const val MIN_SCALED_LEVEL = 0f
    private const val MAX_SCALED_LEVEL = 1f

    /**
     * Scales the raw signal level to a value between 0.0 and 1.0.
     *
     * [MIN_SIGNAL_LEVEL] maps to 0.0, and [MAX_SIGNAL_LEVEL] maps to 1.0.
     * @param rawValue The raw signal level to be scaled.
     * @return The scaled signal level.
     */
    private fun scaleRawSignal(rawValue: Float): Float {
        // Linearly scale the raw value to the range [MIN_SCALED_LEVEL, MAX_SCALED_LEVEL]
        return (MAX_SCALED_LEVEL - MIN_SCALED_LEVEL) * (rawValue - MIN_SIGNAL_LEVEL) / (MAX_SIGNAL_LEVEL - MIN_SIGNAL_LEVEL) + MIN_SCALED_LEVEL
    }

    /**
     * Transforms the raw signal level into a scaled factor between 0.0 and 1.0.
     *
     * @param rawValue The raw signal level.
     * @return The scaled factor.
     */
    internal fun scaleVolume(rawValue: Double): Float {
        // Ensure rawValue is within the specified range [MIN_RAW_LEVEL, MAX_RAW_LEVEL]
        val scaledValue = when {
            rawValue < MIN_SIGNAL_LEVEL -> MIN_SCALED_LEVEL
            rawValue > MAX_SIGNAL_LEVEL -> MAX_SCALED_LEVEL
            else -> scaleRawSignal(rawValue.toFloat())
        }
        return scaledValue
    }

    /**
     * Calculates the volume of audio data based on the amplitude.
     *
     * @param readCount The number of samples read from the audio buffer.
     * @param audioSamples The array containing audio samples.
     * @return The volume of the audio data in decibels (dB).
     */
    internal fun calculateVolume(readCount: Int, audioSamples: ShortArray): Double {
        // Initialize a variable to accumulate the sum of squares of audio samples
        var sumOfSquares: Long = 0

        // Calculate the sum of squares of audio samples
        for (i in 0 until readCount) {
            sumOfSquares += audioSamples[i].toLong() * audioSamples[i].toLong()
        }

        // Calculate the average amplitude
        val averageAmplitude = if (readCount != 0) (sumOfSquares.toDouble() / readCount) else 0.0

        // Calculate the volume in decibels (dB)
        var volumeInDecibels = 0.0
        if (averageAmplitude > 0) {
            volumeInDecibels = 10 * log10(averageAmplitude)
        }

        return volumeInDecibels
    }
}