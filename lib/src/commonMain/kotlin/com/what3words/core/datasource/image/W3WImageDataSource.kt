package com.what3words.core.datasource.image

import com.what3words.core.types.common.W3WError
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.image.W3WImage
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.language.W3WRFC5646Language
import com.what3words.core.types.options.W3WAutosuggestOptions

interface W3WImageDataSource {

    fun start(onReady: () -> Unit, onError: (W3WError) -> Unit)

    fun scan(
        image: W3WImage,
        options: W3WAutosuggestOptions?,
        onScanning: () -> Unit,
        onDetected: () -> Unit,
        onValidating: () -> Unit,
        onResult: (List<W3WSuggestion>) -> Unit,
        onError: (W3WError) -> Unit
    )

    fun stop()
}