package com.what3words.core.types.common

/**
 * Represents an error specific to what3words domain.
 *
 * This class extends the standard Kotlin [Error] class to provide custom error handling functionality.
 * Instances of this class can be used to convey information about errors that occur within what3words domain.
 *
 * @constructor Creates a new instance of [W3WError].
 * @param message A descriptive message providing additional context about the error.
 * @param cause The cause of the error, typically another throwable that caused this throwable to be constructed.
 */
open class W3WError : Error {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}