package com.nugurang.dao

import com.nugurang.entity.ProgressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProgressDao : JpaRepository<ProgressEntity, Long> {
    fun findByName(name: String): ProgressEntity?
}