package com.what3words.core.language.internal

import com.what3words.core.types.domain.W3WAddress
import com.what3words.core.types.domain.W3WCountry
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.language.W3WProprietaryLanguage
import com.what3words.core.types.language.W3WRFC5646Language
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class W3WLanguageSerializerTest {

    @Test
    fun `test W3WLanguage serialization and deserialization as W3WRFC5646Language`() {
        val language: W3WLanguage = W3WRFC5646Language.EN_GB
        val w3wAddress = W3WAddress(
            words = "index.home.raft",
            center = null,
            square = null,
            language = language,
            country = W3WCountry(twoLetterCode = "GB"),
            nearestPlace = "near Bayswater"
        )

        val w3wSuggestion = W3WSuggestion(
            w3wAddress = w3wAddress,
            rank = 1,
            distanceToFocus = null
        )
        val encodedLanguage = Json.encodeToString(language)
        val encodedW3WAddress = Json.encodeToString(w3wAddress)
        val encodedW3WSuggestion = Json.encodeToString(w3wSuggestion)

        val decodedLanguage = Json.decodeFromString<W3WRFC5646Language>(encodedLanguage)
        val decodedW3WAddress = Json.decodeFromString<W3WAddress>(encodedW3WAddress)
        val decodedW3WSuggestion = Json.decodeFromString<W3WSuggestion>(encodedW3WSuggestion)

        // Assert serializations
        assertEquals(encodedLanguage, """{"name":"EN_GB","code":"en-GB","w3wCode":"en","w3wLocale":null}""")
        assertEquals(
            encodedW3WAddress,
            """{"words":"index.home.raft","center":null,"square":null,"language":{"name":"EN_GB","code":"en-GB","w3wCode":"en","w3wLocale":null},"country":{"twoLetterCode":"GB"},"nearestPlace":"near Bayswater"}"""
        )
        assertEquals(
            encodedW3WSuggestion,
            """{"w3wAddress":{"words":"index.home.raft","center":null,"square":null,"language":{"name":"EN_GB","code":"en-GB","w3wCode":"en","w3wLocale":null},"country":{"twoLetterCode":"GB"},"nearestPlace":"near Bayswater"},"rank":1,"distanceToFocus":null}"""
        )

        // Assert deserializations
        assertEquals(decodedLanguage, W3WRFC5646Language.EN_GB)
        assertEquals(decodedW3WAddress, w3wAddress)
        assertEquals(decodedW3WSuggestion, w3wSuggestion)
    }

    @Test
    fun `test W3WLanguage serialization and deserialization as W3WProprietaryLanguage`() {
        val language: W3WLanguage = W3WProprietaryLanguage(
            code = "en",
            locale = null,
            name = "English",
            nativeName = "English"
        )
        val w3wAddress = W3WAddress(
            words = "index.home.raft",
            center = null,
            square = null,
            language = language,
            country = W3WCountry(twoLetterCode = "GB"),
            nearestPlace = "near Bayswater"
        )

        val w3wSuggestion = W3WSuggestion(
            w3wAddress = w3wAddress,
            rank = 1,
            distanceToFocus = null
        )

        val encodedLanguage = Json.encodeToString(language)
        val encodedW3WAddress = Json.encodeToString(w3wAddress)
        val encodedW3WSuggestion = Json.encodeToString(w3wSuggestion)

        val decodedLanguage = Json.decodeFromString<W3WLanguage>(encodedLanguage)
        val decodedW3WAddress = Json.decodeFromString<W3WAddress>(encodedW3WAddress)
        val decodedW3WSuggestion = Json.decodeFromString<W3WSuggestion>(encodedW3WSuggestion)

        // Assert serializations
        assertEquals("""{"code":"en","locale":null,"name":"English","nativeName":"English"}""", encodedLanguage)
        assertEquals("""{"words":"index.home.raft","center":null,"square":null,"language":{"code":"en","locale":null,"name":"English","nativeName":"English"},"country":{"twoLetterCode":"GB"},"nearestPlace":"near Bayswater"}""",encodedW3WAddress)
        assertEquals(   """{"w3wAddress":{"words":"index.home.raft","center":null,"square":null,"language":{"code":"en","locale":null,"name":"English","nativeName":"English"},"country":{"twoLetterCode":"GB"},"nearestPlace":"near Bayswater"},"rank":1,"distanceToFocus":null}""", encodedW3WSuggestion)

        // Assert deserializations
        assertEquals(decodedLanguage, language)
        assertEquals(decodedW3WAddress, w3wAddress)
        assertEquals(decodedW3WSuggestion, w3wSuggestion)
    }
}