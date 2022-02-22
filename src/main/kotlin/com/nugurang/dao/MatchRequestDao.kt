package com.nugurang.dao

import com.nugurang.entity.MatchRequestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
interface MatchRequestDao : JpaRepository<MatchRequestEntity, Long> {
    fun findAllByEventId(event: Long): List<MatchRequestEntity>
    fun findAllByUserId(user: Long): List<MatchRequestEntity>
    fun findAllByExpiresAtLessThan(at: OffsetDateTime): List<MatchRequestEntity>
}