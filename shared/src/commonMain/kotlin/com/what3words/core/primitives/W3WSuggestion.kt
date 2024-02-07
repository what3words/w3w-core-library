package com.what3words.core.primitives


/**
 * Represents a what3words address suggestion, including the address details, rank, and optional distance to focus.
 *
 * @property w3wAddress The suggested What3Words address.
 * @property rank The rank or relevance score of the suggestion.
 * @property distanceToFocus The distance from the suggestion to the focus point, if available.
 */
data class W3WSuggestion(
    val w3wAddress: W3WAddress,
    val rank: Int,
    val distanceToFocus: W3WDistance?
)