package com.what3words.core.primitives


/**
 * Defines a rectangle using two sets of coordinates in the what3words system.
 * The rectangle is defined by its southwest and northeast corners.
 *
 * @property southwest The coordinates of the southwest corner of the rectangle.
 * @property northeast The coordinates of the northeast corner fo the rectangle.
 * **/
data class W3WRectangle(
    val southwest: W3WCoordinates,
    val northeast: W3WCoordinates
)