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
    class Success<out T>(val value: T) : W3WResult<T>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as Success<*>

            return value == other.value
        }

        override fun hashCode(): Int {
            return value?.hashCode() ?: 0
        }

        override fun toString(): String {
            return "Success(value=$value)"
        }
    }

    /**
     * Data class representing a failed result containing an optional error message and error object of type [W3WError].
     *
     * @param error An optional error object of type [W3WError] representing the cause of the failure.
     * @param message An optional failure message providing additional context. Defaults to the [error] message.
     */
    class Failure<out T>(val error: W3WError, val message: String? = error.message) : W3WResult<T>(){
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as Failure<*>

            if (error != other.error) return false
            if (message != other.message) return false

            return true
        }

        override fun hashCode(): Int {
            var result = error.hashCode()
            result = 31 * result + (message?.hashCode() ?: 0)
            return result
        }

        override fun toString(): String {
            return "Failure(error=$error, message=$message)"
        }
    }
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
