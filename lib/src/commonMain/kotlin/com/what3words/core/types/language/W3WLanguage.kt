package com.what3words.core.types.language

/**
 * Represents a language supported by what3words.
 *
 * @property code Two-letter code representing the language based on [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).
 * For Bosnian-Croatian-Montenegrin-Serbian, use "oo". For a complete list of 3-word address languages, refer to [available-languages](https://developer.what3words.com/public-api/docs#available-languages).
 * @property locale Some languages supported by what3words allow specifying a locale. This allows displaying what3words addresses in a variant of the language.
 * For instance, Mongolian what3words addresses can be displayed in either Cyrillic or Latin characters. By specifying the locale, you can choose either variant when making an API/SDK request.
 * Bosnian-Croatian-Montenegrin-Serbian is available using the language code "oo" with Cyrillic and Latin locales (oo_cy and oo_la). Refer to [supported locales](https://developer.what3words.com/public-api/docs#overview:~:text=that%20enables%20CORS.-,Locales,code%20oo%20with%20Cyrillic%20and%20Latin%20locales%20(oo_cy%20and%20oo_la).,-Supported%20locales%3A) for information on supported what3words locales.
 */
data class W3WLanguage(
    val code: String,
    val locale: String?
)