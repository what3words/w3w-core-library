package com.what3words.core.datasource.voice

import com.what3words.core.datasource.text.W3WTextDataSource
import com.what3words.core.datasource.voice.audiostream.W3WAudioStream
import com.what3words.core.types.common.W3WResult
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.language.W3WProprietaryLanguage
import com.what3words.core.types.language.W3WRFC5646Language
import com.what3words.core.types.options.W3WAutosuggestOptions

/**
 * Provides an interface for interacting with voice-based data sources within the what3words business domain.
 */
interface W3WVoiceDataSource {
    /**
     * Enum class for specifying the version type of the components used in [W3WVoiceDataSource].
     */
    enum class Version {
        /**
         * Represents the version of the library that implemented [W3WVoiceDataSource].
         */
        Library,
        /**
         * Represents the version of the data source where the implementation gets the data from.
         */
        DataSource
    }

    /**
     * Retrieves the version string for a specified component from [W3WVoiceDataSource].
     *
     * @param version The type of version information required. Can be one of [Version.Library] or [Version.DataSource].
     * @return The version string for the requested component, or `null` if the version is not available.
     */
    fun version(version: Version): String?

    /**
     * Performs automatic speech recognition (ASR) on a provided audio stream to return a list of what3words address suggestions.
     *
     * @param input The audio stream (instance of [W3WAudioStream]) providing audio signals for ASR.
     * @param voiceLanguage The language used to initialize the ASR engine.
     * Accepts instances of [W3WRFC5646Language] or [W3WProprietaryLanguage].
     * @param options Additional options for tuning the address suggestions.
     * @param onRawResult callback invoked when the ASR returns a raw unprocessed JSON result (if supported),
     * this will be the JSON used internally by our [W3WTextDataSource] to get processed by autosuggest and return a list of [W3WSuggestion].
     * *Note: Some voice data sources may directly return a list of address suggestions
     * based on the user's speech without providing the raw JSON result*
     * @param onResult Callback invoked when the ASR process is complete, providing a [W3WResult] instance
     * containing a list of what3words address suggestions.
     */
    fun autosuggest(
        input: W3WAudioStream,
        voiceLanguage: W3WLanguage,
        options: W3WAutosuggestOptions?,
        onRawResult: ((String) -> Unit)?,
        onResult: (result: W3WResult<List<W3WSuggestion>>) -> Unit,
    )

    /**
     * Retrieves a set of all available/supported languages for the current instance of the [W3WVoiceDataSource].
     *
     * @return A set of [W3WRFC5646Language] containing the supported languages.
     */
    fun availableLanguages(): Set<W3WRFC5646Language>

    /**
     * Terminates any ongoing autosuggest or speech recognition process within the voice datasource
     * and releases associated resources.
     */
    fun terminate()
}