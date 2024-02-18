package com.what3words.core.types.geometry

/**
 * Represents a line segment in the what3words system, defined by its starting and ending coordinates.
 *
 * @property start The starting coordinates of the line segment.
 * @property end The ending coordinates of the line segment.
 **/
data class W3WLine(
    val start: W3WCoordinates,
    val end: W3WCoordinates
)
