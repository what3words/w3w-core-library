package com.what3words.core.types.geometry

/**
 * Represents coordinates in the what3words system.
 *
 * @property lat The latitude value of the coordinates
 * @property lng The longitude value of the coordinates
 * **/
data class W3WCoordinates(
    val lat: Double,
    val lng: Double
)