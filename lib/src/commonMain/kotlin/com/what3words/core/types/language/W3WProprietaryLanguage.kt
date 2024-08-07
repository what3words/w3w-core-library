package com.what3words.core.types.language

import kotlinx.serialization.Serializable

/**
 * Represents a language used in the what3words system, identified by proprietary language codes controlled by what3words. See [available-languages](https://developer.what3words.com/public-api/docs#available-languages) for more information.
 *
 * @property code Two-letter code representing the language based on [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
 * For Bosnian-Croatian-Montenegrin-Serbian, use "oo". For a complete list of 3-word address languages, refer to [available-languages](https://developer.what3words.com/public-api/docs#available-languages).
 * @property locale Some languages supported by what3words allow specifying a locale. This allows displaying what3words addresses in a variant of the language.
 * For instance, Mongolian what3words addresses can be displayed in either Cyrillic or Latin characters. By specifying the locale, you can choose either variant when making an API/SDK request.
 * Bosnian-Croatian-Montenegrin-Serbian is available using the language code "oo" with Cyrillic and Latin locales (oo_cy and oo_la). Refer to [supported locales](https://developer.what3words.com/public-api/docs#overview:~:text=that%20enables%20CORS.-,Locales,code%20oo%20with%20Cyrillic%20and%20Latin%20locales%20(oo_cy%20and%20oo_la).,-Supported%20locales%3A) for information on supported what3words locales.
 * @property name the English name of the language, for example, Vietnamese.
 * @property nativeName the name of the language in its native form, for example, the native name for Vietnamese is Tiếng Việt.
 */
@Serializable
class W3WProprietaryLanguage(
    val code: String,
    val locale: String?,
    val name: String?,
    val nativeName: String?
) : W3WLanguage {
    override val w3wCode: String
        get() = code
    override val w3wLocale: String?
        get() = locale

    fun copy(
        code: String = this.code,
        locale: String? = this.locale,
        name: String? = this.name,
        nativeName: String? = this.nativeName
    ): W3WProprietaryLanguage = W3WProprietaryLanguage(
        code = code,
        locale = locale,
        name = name,
        nativeName = nativeName
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WProprietaryLanguage

        if (code != other.code) return false
        if (locale != other.locale) return false
        if (name != other.name) return false
        if (nativeName != other.nativeName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + (locale?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (nativeName?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "W3WProprietaryLanguage(code='$code', locale=$locale, name=$name, nativeName=$nativeName, w3wCode='$w3wCode', w3wLocale=$w3wLocale)"
    }
}