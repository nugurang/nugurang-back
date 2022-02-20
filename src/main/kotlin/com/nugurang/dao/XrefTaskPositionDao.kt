package com.nugurang.dao

import com.nugurang.entity.XrefTaskPositionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefTaskPositionDao : JpaRepository<XrefTaskPositionEntity, Long> {
    fun findAllByTaskId(task: Long): List<XrefTaskPositionEntity>
}