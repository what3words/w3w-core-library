package com.what3words.core.datasource.voice.audiostream

import kotlinx.coroutines.sync.Semaphore
import com.what3words.core.datasource.voice.W3WVoiceDataSource

/**
 * Proxy class for the [W3WAudioStream], providing controlled access to its internal methods and attributes, which are intended
 * to be accessed only by implementations of [W3WVoiceDataSource].
 */
class W3WAudioStreamProxy(private val stream: W3WAudioStream) {
    // Semaphore to control access to the audio stream session
    private val sessionSemaphore: Semaphore = Semaphore(1)

    /**
     * Retrieves the configuration of the underlying audio stream.
     * Equivalent to accessing [W3WAudioStream.config].
     */
    val config: W3WAudioStreamConfig = stream.config

    /**
     * Opens the audio input stream for processing audio signals.
     *
     * @param onAudioSignal Callback function to handle incoming audio signals.
     * @param forceOpen Flag indicating whether to forcefully open the stream even if it's already open.
     *                  Defaults to false.
     *
     * Note: This method controls access to the underlying audio stream based on the semaphore.
     * If forceOpen is false and the stream is already open, the method returns without opening it again.
     * If forceOpen is true, the method closes the existing stream and then opens a new one.
     */
    fun openAudioInputStream(
        onAudioSignal: (readCount: Int, buffer: ShortArray) -> Unit,
        forceOpen: Boolean
    ) {
        // Only attempt to acquire semaphore if forceOpen is false
        if (!forceOpen && !sessionSemaphore.tryAcquire()) {
            return // Stream is already open, no need to open again
        }

        // If forceOpen is true or semaphore is acquired successfully, proceed to open the stream
        // Close existing stream only if it's not already closed and forceOpen is true
        if (forceOpen && sessionSemaphore.availablePermits == 0) {
            closeAudioInputStream()
        }

        // Open the audio input stream
        stream.openAudioInputStream(onAudioSignal)
    }

    /**
     * Closes the audio input stream if it hasn't been closed before.
     * Equivalent to calling [W3WAudioStream.closeAudioInputStream].
     * Releases the session semaphore to allow subsequent openings.
     */
    fun closeAudioInputStream() {
        // Only close the stream if it hasn't been closed before
        if (sessionSemaphore.availablePermits == 0) {
            // Close the audio input stream
            stream.closeAudioInputStream()

            // Release the session semaphore to allow subsequent openings
            sessionSemaphore.release()
        }
    }
}