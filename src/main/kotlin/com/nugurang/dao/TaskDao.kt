package com.nugurang.dao

import com.nugurang.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskDao : JpaRepository<TaskEntity, Long>, TaskDaoCustom {
    fun findFirstByOrderByOrderDesc(): TaskEntity?
    fun findAllByWorkId(work: Long): List<TaskEntity>
}