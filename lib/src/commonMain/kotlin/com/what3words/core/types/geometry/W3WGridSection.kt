package com.what3words.core.types.geometry

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.putJsonArray
import kotlinx.serialization.json.putJsonObject

/**
 * Represents a section of the 3m x 3m what3words grid for a bounding box.
 *
 * @property lines The list of lines defining the grid section.
 */
@Serializable
class W3WGridSection(
    val lines: List<W3WLine>
) {
    fun copy(lines: List<W3WLine> = this.lines): W3WGridSection = W3WGridSection(lines = lines)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WGridSection

        return lines == other.lines
    }

    override fun hashCode(): Int {
        return lines.hashCode()
    }

    override fun toString(): String {
        return "W3WGridSection(lines=$lines)"
    }
}

/**
 * Converts the grid section to GeoJSON format.
 *
 * @return A GeoJSON representation of the grid section.
 */
fun W3WGridSection.toGeoJSON(): String = Json.encodeToString(buildJsonObject {
    putJsonArray("features") {
        add(buildJsonObject {
            putJsonObject("geometry") {
                putJsonArray("coordinates") {
                    lines.forEach {
                        add(buildJsonArray {
                            add(
                                buildJsonArray {
                                    add(JsonPrimitive(it.start.lng))
                                    add(JsonPrimitive(it.start.lat))
                                }
                            )
                            add(
                                buildJsonArray {
                                    add(JsonPrimitive(it.end.lng))
                                    add(JsonPrimitive(it.end.lat))
                                }
                            )
                        })
                    }
                }
                put("type", JsonPrimitive("MultiLineString"))
            }
            put("type", JsonPrimitive("Feature"))
            putJsonObject("properties") {}
        })
    }
    put("type", JsonPrimitive("FeatureCollection"))
})
