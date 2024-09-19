package com.what3words.core.datasource.image

import com.what3words.core.types.language.W3WLanguage

interface W3WLanguageSupportImageDataSource : W3WImageDataSource {

    fun setLanguage(language: W3WLanguage)

    fun supportsLanguage(language: W3WLanguage): Boolean

    fun availableLanguages(): List<W3WLanguage>
}