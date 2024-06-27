package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable

/**
 * Represents a distance in kilometers in the what3words system.
 *
 * @property distance The distance value in kilometers.
 */
@Serializable
class W3WDistance(
    val distance: Double
) {
    fun copy(distance: Double = this.distance): W3WDistance = W3WDistance(distance = distance)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WDistance

        return distance == other.distance
    }

    override fun hashCode(): Int {
        return distance.hashCode()
    }

    override fun toString(): String {
        return "W3WDistance(distance=$distance)"
    }
}

/**
 * Returns the distance in meters.
 * @return The distance value converted to meters.
 */
fun W3WDistance.m(): Double {
    return distance * 1000
}

/**
 * Returns the distance in kilometers.
 * @return The distance value in kilometers.
 */
fun W3WDistance.km(): Double {
    return distance
}
