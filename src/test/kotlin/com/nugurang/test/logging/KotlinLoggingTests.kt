package com.nugurang.test.logging

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.test.Test

internal class KotlinLoggingTests {
    @Test
    fun test() {
        val logger = KotlinLogging.logger {}
        logger.info { "hello world" }
    }
}
