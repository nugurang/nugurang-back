package com.nugurang.dao

import com.nugurang.entity.UserReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserReviewDao : JpaRepository<UserReviewEntity, Long> {
    fun findAllByToUserId(toUser: Long): List<UserReviewEntity>
    fun findAllByToUserIdIn(toUsers: List<Long>): List<UserReviewEntity>
    fun findAllByUserEvaluationId(userEvaluation: Long): List<UserReviewEntity>
    fun deleteAllByIdIn(ids: List<Long>)
    fun deleteAllByUserEvaluationIdAndFromUserId(userEvaluation: Long, fromUser: Long)
    fun deleteByUserEvaluationIdAndFromUserIdAndToUserId(
        userEvaluation: Long,
        fromUser: Long,
        toUser: Long
    )
}