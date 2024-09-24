package com.what3words.core.datasource.image

import com.what3words.core.types.common.W3WError
import com.what3words.core.types.domain.W3WSuggestion
import com.what3words.core.types.image.W3WImage
import com.what3words.core.types.options.W3WAutosuggestOptions

/**
 * Interface to scan images and detect what3words addresses.
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
     * Scans the image to detect what3words addresses.
     *
     * @param image The image to scan.
     * @param options the [W3WAutosuggestOptions] to be applied when validating a possible what3words address,
     * i.e: country clipping, check [W3WAutosuggestOptions] for possible filters/clippings.
     * @param onScanning the callback when it starts to scan image for text.
     * @param onDetected the callback when our [findPossible3wa] regex finds possible matches on the scanned text.
     * @param onValidating the callback when we start validating the results of [findPossible3wa] against our API/SDK to check if valid (it will take into account [options] if provided).
     * @param onResult Callback when the scan is completed with the detected what3words addresses.
     * @param onError Callback when an error occurs.
     **/
    fun scan(
        image: W3WImage,
        options: W3WAutosuggestOptions?,
        onScanning: () -> Unit,
        onDetected: () -> Unit,
        onValidating: () -> Unit,
        onResult: (List<W3WSuggestion>) -> Unit,
        onError: (W3WError) -> Unit
    )

    /**
     * Stops the scanning process and cleans up internal resources.
     */
    fun stop()
}