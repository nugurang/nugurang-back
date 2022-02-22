package com.nugurang.dao

import com.nugurang.entity.MatchTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchTypeDao : JpaRepository<MatchTypeEntity, Long> {
    fun findByName(name: String): MatchTypeEntity?
}