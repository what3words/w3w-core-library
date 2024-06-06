package com.what3words.core.types.language.internal

import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.language.W3WProprietaryLanguage
import com.what3words.core.types.language.W3WRFC5646Language
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer

/**
 * Serializer for the [W3WLanguage] interface. This serializer handles instances of [W3WLanguage] by
 * serializing them to either [W3WProprietaryLanguage] or [W3WRFC5646Language] based on the actual
 * instance type.
 */
internal object W3WLanguageSerializer : KSerializer<W3WLanguage> {
    private val mapSerializer: KSerializer<LinkedHashMap<String, String?>> = serializer()

    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor =
        SerialDescriptor(W3WLanguage::class.simpleName!!, mapSerializer.descriptor)

    override fun serialize(encoder: Encoder, value: W3WLanguage) {
        val data = linkedMapOf<String, String?>()
        when (value) {
            is W3WProprietaryLanguage -> {
                data[W3WProprietaryLanguage::code.name] = value.code
                data[W3WProprietaryLanguage::locale.name] = value.locale
                data[W3WProprietaryLanguage::name.name] = value.name
                data[W3WProprietaryLanguage::nativeName.name] = value.name
            }

            else -> {
                value as W3WRFC5646Language
                data[W3WRFC5646Language::name.name] = value.name
                data[W3WRFC5646Language::code.name] = value.code
                data[W3WRFC5646Language::w3wCode.name] = value.w3wCode
                data[W3WRFC5646Language::w3wLocale.name] = value.w3wLocale
            }
        }
        encoder.encodeSerializableValue(mapSerializer, data)
    }

    override fun deserialize(decoder: Decoder): W3WLanguage {
        val map = decoder.decodeSerializableValue(mapSerializer)
        return if (map.containsKey(W3WProprietaryLanguage::nativeName.name)) {
            W3WProprietaryLanguage(
                code = map[W3WProprietaryLanguage::code.name]!!,
                locale = map[W3WProprietaryLanguage::locale.name],
                name = map[W3WProprietaryLanguage::name.name],
                nativeName = map[W3WProprietaryLanguage::nativeName.name]
            )
        } else {
            W3WRFC5646Language.valueOf(map[W3WRFC5646Language::name.name]!!)
        }
    }
}