package com.what3words.core.primitives


/**
 * Represents a what3words address.
 *
 * @property words The three words identifying the location e.g filled.count.soap.
 * @property center The coordinates of the center point of the What3Words address, if available.
 * @property square The rectangle defined by two sets of coordinates enclosing the area of the What3Words address, if available.
 * @property language The language used for the What3Words address.
 * @property country The country associated with the What3Words address.
 * @property nearestPlace The nearest place or landmark to the What3Words address.
 */
data class W3WAddress(
    private val words: String,
    val center: W3WCoordinates?,
    val square: W3WRectangle?,
    val language: W3WLanguage,
    val country: W3WCountry,
    val nearestPlace: String
) {
    /**
     * Constructs the full What3Words address format with three slashes in front of the words.
     * Example: "///filled.count.soap"
     */
    val address: String get() = "///$words"
}