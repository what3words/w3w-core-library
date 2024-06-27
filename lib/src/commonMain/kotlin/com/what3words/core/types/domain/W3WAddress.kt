package com.what3words.core.types.domain

import com.what3words.core.types.geometry.W3WCoordinates
import com.what3words.core.types.geometry.W3WRectangle
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.language.internal.W3WLanguageSerializer
import kotlinx.serialization.Serializable


/**
 * Represents a what3words address.
 *
 * @property words The three words identifying the location e.g filled.count.soap.
 * @property center The coordinates of the center point of the what3words address, if available.
 * @property square The rectangle defined by two sets of coordinates enclosing the area of the what3words address, if available.
 * @property language The language used for the what3words address.
 * @property country The country associated with the what3words address.
 * @property nearestPlace The nearest place or landmark to the what3words address.
 */
@Serializable
class W3WAddress(
    val words: String,
    val center: W3WCoordinates?,
    val square: W3WRectangle?,
    @Serializable(with = W3WLanguageSerializer::class)
    val language: W3WLanguage,
    val country: W3WCountry,
    val nearestPlace: String
) {
    fun copy(
        words: String = this.words, center: W3WCoordinates? = this.center,
        square: W3WRectangle? = this.square, language: W3WLanguage = this.language,
        country: W3WCountry = this.country, nearestPlace: String = this.nearestPlace
    ): W3WAddress = W3WAddress(
        words = words,
        center = center,
        square = square,
        language = language,
        country = country,
        nearestPlace = nearestPlace
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WAddress

        if (words != other.words) return false
        if (center != other.center) return false
        if (square != other.square) return false
        if (language != other.language) return false
        if (country != other.country) return false
        if (nearestPlace != other.nearestPlace) return false

        return true
    }

    override fun hashCode(): Int {
        var result = words.hashCode()
        result = 31 * result + (center?.hashCode() ?: 0)
        result = 31 * result + (square?.hashCode() ?: 0)
        result = 31 * result + language.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + nearestPlace.hashCode()
        return result
    }

    override fun toString(): String {
        return "W3WAddress(words='$words', center=$center, square=$square, language=$language, country=$country, nearestPlace='$nearestPlace')"
    }
}

/**
 * Constructs the full What3Words address format with three slashes in front of the words.
 * Example: "///filled.count.soap"
 */
fun W3WAddress.formattedWords(): String {
    return "///$words"
}