package com.what3words.core.datasource.text

import com.what3words.core.types.domain.W3WAddress
import com.what3words.core.types.geometry.W3WCoordinates
import com.what3words.core.types.common.W3WResult
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.geometry.W3WRectangle
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.geometry.W3WGridSection
import com.what3words.core.types.language.W3WRFC5646Language
import com.what3words.core.types.language.W3WProprietaryLanguage
import com.what3words.core.types.options.W3WAutosuggestOptions


/**
 * This interface provides an API for interacting with text-based data sources within what3words business domain
 */
interface W3WTextDataSource {

    /**
     * Enum class for specifying the version type of the components used in [W3WTextDataSource].
     */
    enum class Version {
        /**
         * Represents the version of the library that implemented [W3WTextDataSource].
         */
        Library,
        /**
         * Represents the version of the data source where the implementation gets the data from.
         */
        DataSource,
        /**
         * Represents the version of the raw data files that the data source implementation is using.
         */
        Data
    }

    /**
     * Retrieves the version string for a specified component from [W3WTextDataSource].
     *
     * @param version The type of version information required. Can be one of [Version.Library], [Version.DataSource], or [Version.Data].
     * @return The version string for the requested component, or `null` if the version is not available.
     */
    fun version(version: Version): String?

    /**
     * Converts a latitude and longitude to a what3words address.
     * Additionally provides country information, grid square bounds, nearest place, and a map link.
     *
     * @param coordinates The latitude and longitude of the location to convert to a what3words address.
     * @param language The language in which the what3words address should be provided. Accepts instances of [W3WRFC5646Language] or [W3WProprietaryLanguage].
     * @return A [W3WResult] instance containing the what3words address.
     */
    fun convertTo3wa(coordinates: W3WCoordinates, language: W3WLanguage): W3WResult<W3WAddress>

    /**
     * Converts a what3words address to coordinates.
     *
     * @param words A what3words address as a string.
     * @return A [W3WResult] instance containing the what3words address.
     */
    fun convertToCoordinates(words: String): W3WResult<W3WAddress>

    /**
     * [autosuggest] can take a slightly incorrect what3words address and suggest a list of valid what3words addresses.
     * It can optionally limit results to a country or area and prefer results near the user.
     *
     * @param input The full or partial what3words address to obtain suggestions for.
     * @param options Additional options for auto suggestion.
     * @return A [W3WResult] instance containing a list of what3words address suggestions.
     */
    fun autosuggest(input: String, options: W3WAutosuggestOptions?): W3WResult<List<W3WSuggestion>>

    /**
     * Returns a section of the what3words grid for a bounding box.
     *
     * @param boundingBox The bounding box for which the grid section should be returned.
     * @return A [W3WResult] instance representing the requested what3words grid section.
     */
    fun gridSection(boundingBox: W3WRectangle): W3WResult<W3WGridSection>

    /**
     * Retrieves a set of all available what3words languages.
     *
     * @return A [W3WResult] instance containing a set of available what3words languages.
     */
    fun availableLanguages(): W3WResult<Set<W3WProprietaryLanguage>>

    /**
     * Determines if a possible what3words address is valid.
     *
     * @param words The possible what3words address to validate.
     * @return A [W3WResult] instance containing a boolean value indicating whether the what3words address is valid.
     */
    fun isValid3wa(words: String): W3WResult<Boolean>
}
