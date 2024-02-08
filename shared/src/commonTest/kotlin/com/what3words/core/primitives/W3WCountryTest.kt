package com.what3words.core.primitives

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class W3WCountryTest {
    @Test
    fun `test isLand returns true for a valid country code`() {
        val country = W3WCountry("US")
        assertTrue(country.isLand())
    }

    @Test
    fun `test isLand returns false for the code ZZ`() {
        assertFalse(W3WCountry("ZZ").isLand())
        assertFalse(W3WCountry("zz").isLand())
        assertFalse(W3WCountry("Zz").isLand())
        assertFalse(W3WCountry("zZ").isLand())
    }

}