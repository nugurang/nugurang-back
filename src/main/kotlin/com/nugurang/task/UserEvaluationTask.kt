package com.nugurang.task

import com.nugurang.service.UserEvaluationService
import com.nugurang.task.UserEvaluationTask
import io.github.oshai.kotlinlogging.KotlinLogging
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class UserEvaluationTask(private val userEvaluationService: UserEvaluationService) {
    private val logger = KotlinLogging.logger {}
    //@Scheduled(fixedDelay = 10000)
    private fun evaluateUsers() {
        logger.info { "user evaluation task" }
        userEvaluationService.evaluateUsers()
    }
}
