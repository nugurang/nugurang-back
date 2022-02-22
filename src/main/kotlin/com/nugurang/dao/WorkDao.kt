package com.nugurang.dao

import com.nugurang.entity.WorkEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkDao : JpaRepository<WorkEntity, Long?> {
    fun findFirstByOrderByOrderDesc(): WorkEntity?
    fun findAllByProjectId(project: Long?): List<WorkEntity>
}