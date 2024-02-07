package com.what3words.core.primitives


/**
 * Represents coordinates in the what3words system.
 *
 * @property latitude The latitude value of the coordinates
 * @property longitude The longitude value of the coordinates
 * **/
data class W3WCoordinates(
    val latitude: Double,
    val longitude: Double
)