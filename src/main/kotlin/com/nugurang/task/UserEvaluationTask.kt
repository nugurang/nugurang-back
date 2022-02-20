package com.nugurang.task

import com.nugurang.service.UserEvaluationService
import com.nugurang.task.UserEvaluationTask
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class UserEvaluationTask(private val userEvaluationService: UserEvaluationService) {
    @Scheduled(fixedDelay = 10000)
    private fun evaluateUsers() {
        log.info("user evaluation task")
        userEvaluationService.evaluateUsers()
    }

    companion object {
        private val log = LoggerFactory.getLogger(UserEvaluationTask::class.java)
    }
}