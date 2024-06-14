package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable

/**
 * Defines a rectangle using two sets of coordinates in the what3words system.
 * The rectangle is defined by its southwest and northeast corners.
 *
 * @property southwest The coordinates of the southwest corner of the rectangle.
 * @property northeast The coordinates of the northeast corner fo the rectangle.
 * **/
@Serializable
class W3WRectangle(
    val southwest: W3WCoordinates,
    val northeast: W3WCoordinates
) {
    fun copy(southwest: W3WCoordinates, northeast: W3WCoordinates): W3WRectangle = W3WRectangle(
        southwest = southwest,
        northeast = northeast
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WRectangle

        if (southwest != other.southwest) return false
        if (northeast != other.northeast) return false

        return true
    }

    override fun hashCode(): Int {
        var result = southwest.hashCode()
        result = 31 * result + northeast.hashCode()
        return result
    }

    override fun toString(): String {
        return "W3WRectangle(southwest=$southwest, northeast=$northeast)"
    }
}