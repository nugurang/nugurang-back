package com.nugurang.test.logging

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.test.Test

internal class KotlinLoggingTests {
    @Test
    fun `Should show a log message`() {
        val logger = KotlinLogging.logger {}
        logger.info { "Should show a log message" }
    }
}
