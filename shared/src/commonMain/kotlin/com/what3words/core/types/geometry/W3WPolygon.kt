package com.what3words.core.types.geometry

/**
 * Represents a polygon in the what3words system.
 * A polygon is defined by a sequence of coordinates forming its vertices.
 *
 * @property points The list of coordinates representing the vertices of the polygon.
 */
data class W3WPolygon(
    val points: List<W3WCoordinates>
)