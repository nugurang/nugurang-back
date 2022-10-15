package com.nugurang.exception

class DataIntegrityViolationException : RuntimeException {
    val className: String

    constructor(`class`: Class<*>) : super(`class`.canonicalName) {
        this.className = `class`.canonicalName
    }

    constructor(`class`: Class<*>, message: String) : super(message) {
        this.className = `class`.canonicalName
    }

    constructor(`class`: Class<*>, message: String, cause: Throwable) : super(message, cause) {
        this.className = `class`.canonicalName
    }

    constructor(`class`: Class<*>, cause: Throwable) : super(`class`.canonicalName, cause) {
        this.className = `class`.canonicalName
    }
}
