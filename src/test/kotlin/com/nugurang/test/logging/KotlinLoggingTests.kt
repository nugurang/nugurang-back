package com.nugurang.test.logging

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.test.Test

internal class KotlinLoggingTests {
    @Test
    fun `Show which logging levels are enabled in a unit test`() {
        val logger = KotlinLogging.logger {}
        logger.trace { "TRACE log" }
        logger.debug { "DEBUG log" }
        logger.info { "INFO log" }
        logger.warn { "WARN log" }
        logger.error { "ERROR log" }
    }
}
