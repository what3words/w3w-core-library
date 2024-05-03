package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable

/**
 * Represents a line segment in the what3words system, defined by its starting and ending coordinates.
 *
 * @property start The starting coordinates of the line segment.
 * @property end The ending coordinates of the line segment.
 **/
@Serializable
class W3WLine(
    val start: W3WCoordinates,
    val end: W3WCoordinates
) {
    fun copy(start: W3WCoordinates = this.start, end: W3WCoordinates = this.end): W3WLine = W3WLine(
        start = start,
        end = end
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WLine

        if (start != other.start) return false
        if (end != other.end) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start.hashCode()
        result = 31 * result + end.hashCode()
        return result
    }

    override fun toString(): String {
        return "W3WLine(start=$start, end=$end)"
    }
}
