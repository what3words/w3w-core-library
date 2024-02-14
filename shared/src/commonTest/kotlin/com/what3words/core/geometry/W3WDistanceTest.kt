package com.what3words.core.geometry

import com.what3words.core.types.geometry.W3WDistance
import kotlin.test.Test
import kotlin.test.assertEquals

class W3WDistanceTest {
    @Test
    fun `test m should convert distance to meters`() {
        val distanceInKm = 10.0
        val w3wDistance = W3WDistance(distanceInKm)

        val expectedDistanceInMeters = distanceInKm * 1000
        val actualDistanceInMeters = w3wDistance.m()

        assertEquals(expectedDistanceInMeters, actualDistanceInMeters)
    }

    @Test
    fun `test km should return distance in kilometers`() {
        val distanceInKm = 10.0
        val w3wDistance = W3WDistance(distanceInKm)

        val actualDistanceInKm = w3wDistance.km()

        assertEquals(distanceInKm, actualDistanceInKm)
    }
}