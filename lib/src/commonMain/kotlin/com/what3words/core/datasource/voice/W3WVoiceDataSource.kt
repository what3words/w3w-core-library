package com.what3words.core.datasource.voice

import com.what3words.core.datasource.voice.audiostream.W3WAudioStream
import com.what3words.core.types.common.W3WResult
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.options.W3WAutosuggestOptions

/**
 * Provides an interface for interacting with voice-based data sources within the what3words business domain.
 */
interface W3WVoiceDataSource {
    /**
     * Performs automatic speech recognition (ASR) on a provided audio stream to return a list of what3words address suggestions.
     *
     * @param input The audio stream (instance of [W3WAudioStream]) providing audio signals for ASR.
     * @param voiceLanguage The language used to initialize the ASR engine.
     *                      Accepts instances of [W3WRFC5646Language] or [W3WProprietaryLanguage].
     * @param options Additional options for tuning the address suggestions.
     * @param onSpeechDetected Callback invoked when a voice data source detects and synthesizes user speech,
     *                         providing immediate ASR results. This callback is triggered before initiating
     *                         what3words address suggestion process based on the recognized speech text.
     *                         **Some voice data sources may directly return a list of address suggestions
     *                         based on the user's speech without providing the speech text to the client.**
     * @param onResult Callback invoked when the ASR process is complete, providing a [W3WResult] instance
     *                 containing a list of what3words address suggestions.
     */
    fun autosuggest(
        input: W3WAudioStream,
        voiceLanguage: W3WLanguage,
        options: W3WAutosuggestOptions?,
        onSpeechDetected: ((String) -> Unit)?,
        onResult: (result: W3WResult<List<W3WSuggestion>>) -> Unit,
    )

    /**
     * Terminates any ongoing autosuggest or speech recognition process within the voice datasource
     * and releases associated resources.
     */
    fun terminate()
}