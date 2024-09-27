package com.what3words.core.datasource.image

import com.what3words.core.types.common.W3WError
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.image.W3WImage
import com.what3words.core.types.options.W3WAutosuggestOptions

/**
 * Interface to scan images and detect possible what3words addresses.
 *
 * @see [W3WLanguageSupportImageDataSource].
 */
interface W3WImageDataSource {

    /**
     * Starts the DataSource to be ready to scan images. This method must be called before [scan].
     *
     * @param onReady Callback when the DataSource is ready to scan images.
     * @param onError Callback when an error occurs.
     **/
    fun start(onReady: () -> Unit, onError: (W3WError) -> Unit)

    /**
     * Scans the image to detect possible what3words addresses.
     *
     * @param image The image to scan.
     * @param onScanning the callback when it starts to scan image for text.
     * @param onDetected the callback when our [findPossible3wa] regex finds possible matches on the scanned text.
     * @param onError Callback when an error occurs.
     * @param onCompleted Callback when the scanning process is completed.
     **/
    fun scan(
        image: W3WImage,
        onScanning: () -> Unit,
        onDetected: (List<String>) -> Unit,
        onError: (W3WError) -> Unit,
        onCompleted: () -> Unit
    )

    /**
     * Stops the scanning process and cleans up internal resources.
     */
    fun stop()
}