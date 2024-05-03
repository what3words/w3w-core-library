package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable

/**
 * Represents a circle in the what3words system.
 * A circle is defined by its center point and radius.
 *
 * @property center The coordinates of the center of the circle.
 * @property radius The radius of the circle.
 */
@Serializable
class W3WCircle(
    val center: W3WCoordinates,
    val radius: W3WDistance
) {
    fun copy(center: W3WCoordinates = this.center, radius: W3WDistance = this.radius): W3WCircle =
        W3WCircle(center = center, radius = radius)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WCircle

        if (center != other.center) return false
        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        var result = center.hashCode()
        result = 31 * result + radius.hashCode()
        return result
    }

    override fun toString(): String {
        return "W3WCircle(center=$center, radius=$radius)"
    }
}
