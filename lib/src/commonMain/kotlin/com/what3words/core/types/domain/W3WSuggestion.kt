package com.what3words.core.types.domain

import com.what3words.core.types.geometry.W3WDistance
import kotlinx.serialization.Serializable


/**
 * Represents a what3words address suggestion, including the address details, rank, and optional distance to focus.
 *
 * @property w3wAddress The suggested what3words address.
 * @property rank The rank or relevance score of the suggestion.
 * @property distanceToFocus The distance from the suggestion to the focus point, if available.
 */
@Serializable
class W3WSuggestion(
    val w3wAddress: W3WAddress,
    val rank: Int,
    val distanceToFocus: W3WDistance?
) {
    fun copy(
        w3wAddress: W3WAddress = this.w3wAddress,
        rank: Int = this.rank,
        distanceToFocus: W3WDistance? = this.distanceToFocus
    ): W3WSuggestion = W3WSuggestion(
        w3wAddress = w3wAddress,
        rank = rank,
        distanceToFocus = distanceToFocus
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WSuggestion

        if (w3wAddress != other.w3wAddress) return false
        if (rank != other.rank) return false
        if (distanceToFocus != other.distanceToFocus) return false

        return true
    }

    override fun hashCode(): Int {
        var result = w3wAddress.hashCode()
        result = 31 * result + rank
        result = 31 * result + (distanceToFocus?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "W3WSuggestion(w3wAddress=$w3wAddress, rank=$rank, distanceToFocus=$distanceToFocus)"
    }
}