package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable

/**
 * Represents coordinates in the what3words system.
 *
 * @property lat The latitude value of the coordinates
 * @property lng The longitude value of the coordinates
 * **/
@Serializable
class W3WCoordinates(
    val lat: Double,
    val lng: Double
) {
    fun copy(lat: Double = this.lat, lng: Double = this.lng): W3WCoordinates = W3WCoordinates(
        lat = lat,
        lng = lng
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WCoordinates

        if (lat != other.lat) return false
        if (lng != other.lng) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lat.hashCode()
        result = 31 * result + lng.hashCode()
        return result
    }

    override fun toString(): String {
        return "W3WCoordinates(lat=$lat, lng=$lng)"
    }
}