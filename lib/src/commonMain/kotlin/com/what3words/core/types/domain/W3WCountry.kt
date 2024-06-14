package com.what3words.core.types.domain

import kotlinx.serialization.Serializable

/**
 * Represents a country in the what3words system.
 *
 * @property twoLetterCode The two-letter country code according to [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) standard.
 * Example codes include GB (United Kingdom), US (United States of America), and BE (Belgium)
 */
@Serializable
class W3WCountry(
    val twoLetterCode: String
) {
    fun copy(twoLetterCode: String = this.twoLetterCode): W3WCountry =
        W3WCountry(twoLetterCode = twoLetterCode)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WCountry

        return twoLetterCode == other.twoLetterCode
    }

    override fun hashCode(): Int {
        return twoLetterCode.hashCode()
    }

    override fun toString(): String {
        return "W3WCountry(twoLetterCode='$twoLetterCode')"
    }
}

/**
 * Checks if the country is a valid land area.
 * @return true if the country is a land area, false otherwise.
 */
fun W3WCountry.isLand(): Boolean {
    return !twoLetterCode.equals("ZZ", ignoreCase = true)
}