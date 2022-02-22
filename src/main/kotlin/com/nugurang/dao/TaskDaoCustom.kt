package com.nugurang.dao

import com.nugurang.entity.TaskEntity

interface TaskDaoCustom {
    fun findAllByProjectId(project: Long): List<TaskEntity>
    fun findAllByUserId(user: Long): List<TaskEntity>
}