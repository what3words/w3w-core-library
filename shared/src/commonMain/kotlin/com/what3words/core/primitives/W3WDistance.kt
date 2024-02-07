package com.what3words.core.primitives

/**
 * Represents a distance in kilometers in the what3words system.
 *
 * @property distance The distance value in kilometers.
 */
data class W3WDistance(
    private val distance: Double
) {
    /**
     * Returns the distance in meters.
     * @return The distance value converted to meters.
     */
    fun m(): Double {
        return distance * 1000
    }

    /**
     * Returns the distance in kilometers.
     * @return The distance value in kilometers.
     */
    fun km(): Double {
        return distance
    }
}
