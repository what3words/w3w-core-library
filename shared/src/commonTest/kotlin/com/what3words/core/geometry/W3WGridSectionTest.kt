package com.what3words.core.geometry

import com.what3words.core.types.geometry.W3WCoordinates
import com.what3words.core.types.geometry.W3WGridSection
import com.what3words.core.types.geometry.W3WLine
import kotlin.test.Test
import kotlin.test.assertEquals

class W3WGridSectionTest {
    @Test
    fun `test toGeoJSON with valid lines`() {
        val lines = listOf(
            W3WLine(W3WCoordinates(0.0, 0.0), W3WCoordinates(1.0, 3.0)),
            W3WLine(W3WCoordinates(6.0, 2.0), W3WCoordinates(3.0, 5.0))
        )
        val gridSection = W3WGridSection(lines)

        val geoJSON = gridSection.toGeoJSON()

        val expectedGeoJSON = """
                {
                    "features": [
                        {
                            "geometry": {
                                "coordinates": [
                                    [
                                        [
                                            0.0,
                                            0.0
                                        ],
                                        [
                                            3.0,
                                            1.0
                                        ]
                                    ],
                                    [
                                        [
                                            2.0,
                                            6.0
                                        ],
                                        [
                                            5.0,
                                            3.0
                                        ]
                                    ]
                                ],
                                "type": "MultiLineString"
                            },
                            "type": "Feature",
                            "properties": {
                            }
                        }
                    ],
                    "type": "FeatureCollection"
                }
        """.trimIndent().replace(Regex("[\n\r ]+"), "")

        assertEquals(expectedGeoJSON, geoJSON)
    }

    @Test
    fun `test toGeoJSON with empty lines list`() {
        val gridSection = W3WGridSection(emptyList())


        val geoJSON = gridSection.toGeoJSON()

        // Assert
        val expectedGeoJSON = """
                {
                    "features": [
                        {
                            "geometry": {
                                "coordinates": [],
                                "type": "MultiLineString"
                            },
                            "type": "Feature",
                            "properties": {
                            }
                        }
                    ],
                    "type": "FeatureCollection"
                }
        """.trimIndent().replace(Regex("[\n\r ]+"), "")

        assertEquals(expectedGeoJSON, geoJSON)
    }

    @Test
    fun `test toGeoJSON with valid lines two`() {
        val lines = listOf(
            W3WLine(
                W3WCoordinates(latitude = 52.208009918068136, longitude = 0.116126),
                W3WCoordinates(latitude = 52.208009918068136, longitude = 0.11754)
            ),
            W3WLine(
                W3WCoordinates(latitude = 52.20803686934023, longitude = 0.116126),
                W3WCoordinates(latitude = 52.20803686934023, longitude = 0.11754)
            )
        )
        val gridSection = W3WGridSection(lines = lines)

        val geoJSON = gridSection.toGeoJSON()

        val expectedGeoJSON = """
                {
                    "features": [
                        {
                            "geometry": {
                                "coordinates": [
                                    [
                                        [
                                            0.116126,
                                            52.208009918068136
                                        ],
                                        [
                                            0.11754,
                                            52.208009918068136
                                        ]
                                    ],
                                    [
                                        [
                                            0.116126,
                                            52.20803686934023
                                        ],
                                        [
                                            0.11754,
                                            52.20803686934023
                                        ]
                                    ]
                                ],
                                "type": "MultiLineString"
                            },
                            "type": "Feature",
                            "properties": {
                            }
                        }
                    ],
                    "type": "FeatureCollection"
                }
        """.trimIndent().replace(Regex("[\n\r ]+"), "")
        // Assert
        assertEquals(expectedGeoJSON, geoJSON)
    }
}
