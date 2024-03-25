package com.what3words.core.datasource.voice.audiostream

import android.media.AudioFormat

/**
 * Represents supported audio encoding formats for the [W3WMicrophone] on Android.
 * */
enum class W3WAndroidAudioStreamEncoding : W3WAudioStreamEncoding {
    /**
     * Represents PCM (pulse-code modulation) encoding with 16-bit samples.
     * See [AudioFormat.ENCODING_PCM_16BIT].
     */
    PCM_16BIT {
        override val value: Any = AudioFormat.ENCODING_PCM_16BIT
    },

    /**
     * Represents PCM (pulse-code modulation) encoding with 8-bit samples.
     * See [AudioFormat.ENCODING_PCM_8BIT].
     */
    PCM_8BIT {
        override val value: Any = AudioFormat.ENCODING_PCM_8BIT
    }
}