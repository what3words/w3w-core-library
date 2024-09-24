package com.what3words.core.datasource.image

import com.what3words.core.types.language.W3WLanguage

/**
 * Interface to scan images and detect what3words addresses. This interface extends [W3WImageDataSource]
 * and adds support for language setting and language support check.
 *
 * @see [W3WImageDataSource].
 */
interface W3WLanguageSupportImageDataSource : W3WImageDataSource {

    /**
     * Sets the language to be used when scanning images.
     *
     * @param language The language to set.
     * @throws UnsupportedOperationException if the language is not supported.
     */
    fun setLanguage(language: W3WLanguage)

    /**
     * Checks if the language is supported by the DataSource.
     *
     * @param language The language to check.
     * @return true if the language is supported, false if not.
     */
    fun supportsLanguage(language: W3WLanguage): Boolean

    /**
     * Gets the list of languages supported by the DataSource.
     *
     * @return list of supported languages.
     */
    fun availableLanguages(): List<W3WLanguage>
}