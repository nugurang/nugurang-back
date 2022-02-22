package com.nugurang.dao

import com.nugurang.entity.UserEvaluationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
interface UserEvaluationDao : JpaRepository<UserEvaluationEntity, Long> {
    fun findAllByExpiresAtLessThanEqual(at: OffsetDateTime): List<UserEvaluationEntity>
    fun deleteAllByIdIn(ids: List<Long>)
}