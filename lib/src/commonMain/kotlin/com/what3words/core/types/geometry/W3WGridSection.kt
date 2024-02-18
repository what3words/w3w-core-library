package com.what3words.core.types.geometry

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
data class W3WGridSection(
    val lines: List<W3WLine>
) {

    /**
     * Converts the grid section to GeoJSON format.
     *
     * @return A GeoJSON representation of the grid section.
     */
    fun toGeoJSON(): String = Json.encodeToString(buildJsonObject {
        putJsonArray("features") {
            add(buildJsonObject {
                putJsonObject("geometry") {
                    putJsonArray("coordinates") {
                        lines.forEach {
                            add(buildJsonArray {
                                add(
                                    buildJsonArray {
                                        add(JsonPrimitive(it.start.longitude))
                                        add(JsonPrimitive(it.start.latitude))
                                    }
                                )
                                add(
                                    buildJsonArray {
                                        add(JsonPrimitive(it.end.longitude))
                                        add(JsonPrimitive(it.end.latitude))
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
}
