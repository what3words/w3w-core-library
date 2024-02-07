package com.what3words.core.primitives

/**
 * Represents a country in the what3words system.
 *
 * @property twoLetterCode The two-letter country code according to [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) standard.
 * Example codes include GB (United Kingdom), US (United States of America), and BE (Belgium)
 */
data class W3WCountry(
    val twoLetterCode: String
) {
    /**
     * Checks if the country is a valid land area.
     * @return true if the country is a land area, false otherwise.
     */
    fun isLand(): Boolean {
        return !twoLetterCode.equals("ZZ", ignoreCase = true)
    }
}