package com.what3words.core.datasource.voice.audiostream

import platform.AVFAudio.AVAudioCommonFormat
import platform.AVFAudio.AVAudioPCMFormatFloat32
import platform.AVFAudio.AVAudioPCMFormatInt16

/**
 * Represents supported audio encoding formats for the [W3WMicrophone] on iOS.
 * */
enum class W3WIOSAudioStreamEncoding : W3WAudioStreamEncoding {
    /**
     * Specifies the PCM (pulse-code modulation) format with 32-bit floating-point samples.
     * For more information, refer to [pcmFormatFloat32](https://developer.apple.com/documentation/avfaudio/avaudiocommonformat#:~:text=case%20pcmFormatFloat32).
     **/
    PCM_F32LE {
        override val value: AVAudioCommonFormat = AVAudioPCMFormatFloat32
    },

    /**
     * Specifies the PCM (pulse-code modulation) format with 16-bit signed integer samples.
     * For more information, refer to [pcmFormatInt16](https://developer.apple.com/documentation/avfaudio/avaudiocommonformat#:~:text=native%2Dendian%20doubles.-,case%20pcmFormatInt16,-A%20format%20that).
     * **/
    PCM_S16LE {
        override val value: AVAudioCommonFormat = AVAudioPCMFormatInt16
    }
}