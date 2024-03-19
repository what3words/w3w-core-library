package com.what3words.core.options

import com.what3words.core.types.domain.W3WCountry
import com.what3words.core.types.geometry.W3WCircle
import com.what3words.core.types.geometry.W3WCoordinates
import com.what3words.core.types.geometry.W3WDistance
import com.what3words.core.types.geometry.W3WPolygon
import com.what3words.core.types.geometry.W3WRectangle
import com.what3words.core.types.language.W3WProprietaryLanguage
import com.what3words.core.types.language.W3WRCF5646Language
import com.what3words.core.types.options.W3WAutosuggestInputType
import com.what3words.core.types.options.W3WAutosuggestOptions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class W3WAutosuggestOptionsTest {

    @Test
    fun `builder creates instance with default values`() {
        val options = W3WAutosuggestOptions.Builder().build()

        assertNotNull(options)
        assertEquals(null, options.focus)
        assertEquals(null, options.language)
        assertEquals(3, options.nResults)
        assertEquals(null, options.nFocusResults)
        assertEquals(emptyList(), options.clipToCountry)
        assertEquals(null, options.clipToCircle)
        assertEquals(null, options.clipToBoundingBox)
        assertEquals(null, options.clipToPolygon)
        assertEquals(null, options.inputType)
        assertEquals(false, options.preferLand)
        assertEquals(false, options.includeCoordinates)
    }

    @Test
    fun `builder creates instance with custom values`() {
        val focus = W3WCoordinates(1.0, 2.0)
        val language = W3WProprietaryLanguage(code = "en", locale = null)
        val languageRCF5646 = W3WRCF5646Language.EN_GB
        val nResults = 5
        val nFocusResults = 2
        val clipToCountry = listOf(W3WCountry("US"), W3WCountry("CA"))
        val clipToCircle = W3WCircle(W3WCoordinates(1.0, 2.0), W3WDistance(1000.0))
        val clipToBoundingBox = W3WRectangle(W3WCoordinates(1.0, 2.0), W3WCoordinates(3.0, 4.0))
        val clipToPolygon = W3WPolygon(
            listOf(
                W3WCoordinates(1.0, 2.0),
                W3WCoordinates(3.0, 4.0),
                W3WCoordinates(5.0, 6.0)
            )
        )
        val inputType = W3WAutosuggestInputType.VOCON_HYBRID
        val preferLand = true
        val includeCoordinates = true

        val options = W3WAutosuggestOptions.Builder()
            .focus(focus)
            .language(language)
            .language(languageRCF5646)
            .nResults(nResults)
            .nFocusResults(nFocusResults)
            .clipToCountry(*clipToCountry.toTypedArray())
            .clipToCircle(clipToCircle)
            .clipToBoundingBox(clipToBoundingBox)
            .clipToPolygon(clipToPolygon)
            .inputType(inputType)
            .preferLand(preferLand)
            .includeCoordinates(includeCoordinates)
            .build()

        assertNotNull(options)
        assertEquals(focus, options.focus)
        assertNull(options.language)
        assertEquals(nResults, options.nResults)
        assertEquals(nFocusResults, options.nFocusResults)
        assertEquals(clipToCountry, options.clipToCountry)
        assertEquals(clipToCircle, options.clipToCircle)
        assertEquals(clipToBoundingBox, options.clipToBoundingBox)
        assertEquals(clipToPolygon, options.clipToPolygon)
        assertEquals(inputType, options.inputType)
        assertEquals(preferLand, options.preferLand)
        assertEquals(includeCoordinates, options.includeCoordinates)
    }
}