package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable

/**
 * Represents a polygon in the what3words system.
 * A polygon is defined by a sequence of coordinates forming its vertices.
 *
 * @property points The list of coordinates representing the vertices of the polygon.
 */
@Serializable
class W3WPolygon(
    val points: List<W3WCoordinates>
) {
    fun copy(points: List<W3WCoordinates> = this.points): W3WPolygon = W3WPolygon(
        points = points
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WPolygon

        return points == other.points
    }

    override fun hashCode(): Int {
        return points.hashCode()
    }

    override fun toString(): String {
        return "W3WPolygon(points=$points)"
    }
}