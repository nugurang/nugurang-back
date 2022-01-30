package com.nugurang.dao

import com.nugurang.entity.TaskReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface TaskReviewDao : JpaRepository<TaskReviewEntity, Long> {
    fun findAllByTaskId(task: Long): List<TaskReviewEntity>

    @Transactional
    fun deleteByTaskIdAndUserId(task: Long, user: Long)
}