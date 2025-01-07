package com.what3words.core.types.image

import androidx.compose.ui.graphics.ImageBitmap

expect class W3WImage {
    fun toByteArray(): ByteArray
    fun toImageBitmap(): ImageBitmap
}