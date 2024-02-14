package com.what3words.core.types.geometry

/**
 * Represents a circle in the what3words system.
 * A circle is defined by its center point and radius.
 *
 * @property center The coordinates of the center of the circle.
 * @property radius The radius of the circle.
 */
data class W3WCircle(
    val center: W3WCoordinates,
    val radius: W3WDistance
)
