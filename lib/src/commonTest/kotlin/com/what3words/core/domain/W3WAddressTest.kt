package com.what3words.core.domain

import com.what3words.core.types.domain.W3WAddress
import com.what3words.core.types.domain.W3WCountry
import com.what3words.core.types.geometry.W3WCoordinates
import com.what3words.core.types.geometry.W3WRectangle
import com.what3words.core.types.language.W3WProprietaryLanguage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class W3WAddressTest {
    // Test data
    private val words = "filled.count.soap"
    private val center = W3WCoordinates(lat = 51.520847, lng = -0.195521)
    private val square = W3WRectangle(
        southwest = W3WCoordinates(lat = 51.520847, lng = -0.195521),
        northeast = W3WCoordinates(lat = 51.520847, lng = -0.195521)
    )
    private val language = W3WProprietaryLanguage(
        code = "en", locale = null,
        name = "English", nativeName = "English"
    )
    private val country = W3WCountry(twoLetterCode = "GB")
    private val nearestPlace = "London"

    @Test
    fun `test address property`() {
        val address = W3WAddress(words, center, square, language, country, nearestPlace)
        assertEquals("///filled.count.soap", address.address)
    }

    @Test
    fun `test center property`() {
        val addressWithCenter = W3WAddress(words, center, square, language, country, nearestPlace)
        val addressWithoutCenter = W3WAddress(words, null, square, language, country, nearestPlace)
        assertNotNull(addressWithCenter.center)
        assertEquals(center, addressWithCenter.center)
        assertNull(addressWithoutCenter.center)
    }

    @Test
    fun `test square property`() {
        val addressWithSquare = W3WAddress(words, center, square, language, country, nearestPlace)
        val addressWithoutSquare = W3WAddress(words, center, null, language, country, nearestPlace)
        assertNotNull(addressWithSquare.square)
        assertEquals(square, addressWithSquare.square)
        assertNull(addressWithoutSquare.square)
    }
}