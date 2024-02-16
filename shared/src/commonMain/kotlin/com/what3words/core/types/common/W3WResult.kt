package com.what3words.core.types.common


/**
 * Sealed class representing the result of a operation that can either succeed or fail.
 *
 * @param T The type of the value returned in case of success.
 */
sealed class W3WResult<out T> {

    /**
     * Data class representing a successful result containing a value of type [T].
     *
     * @param value The value returned upon success.
     */
    data class Success<out T>(val value: T) : W3WResult<T>()

    /**
     * Data class representing a failed result containing an optional error message and error object of type [W3WError].
     *
     * @param message An optional error message providing additional context.
     * @param error An optional error object of type [W3WError] representing the cause of the failure.
     */
    data class Failure<out T>(val message: String?, val error: W3WError?) : W3WResult<T>()
}

/**
 * Type alias for representing a successful W3WResult.
 *
 * @param T The type of the value returned in case of success.
 */
typealias W3WSuccess<T> = W3WResult.Success<T>

/**
 * Type alias for representing a failed W3WResult.
 *
 * @param T The type of the value returned in case of failure.
 */
typealias W3WFailure<T> = W3WResult.Failure<T>
