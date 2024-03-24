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
     * Converts a latitude and longitude to a 3 word address.
     * Additionally provides country information, grid square bounds, nearest place, and a map link.
     *
     * @param coordinates The latitude and longitude of the location to convert to a 3 word address.
     * @param language The language in which the 3 word address should be provided. Accepts instances of [W3WRFC5646Language] or [W3WProprietaryLanguage].
     * @return A [W3WResult] instance containing the what3words address.
     */
    fun convertTo3wa(coordinates: W3WCoordinates, language: W3WLanguage): W3WResult<W3WAddress>

    /**
     * Converts a 3 word address to coordinates.
     *
     * @param words A 3 word address as a string.
     * @return A [W3WResult] instance containing the what3words coordinates
     */
    fun convertToCoordinates(words: String): W3WResult<W3WCoordinates>

    /**
     * [autosuggest] can take a slightly incorrect 3 word address and suggest a list of valid 3 word addresses.
     * It can optionally limit results to a country or area and prefer results near the user.
     *
     * @param input The full or partial 3 word address to obtain suggestions for.
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
}
