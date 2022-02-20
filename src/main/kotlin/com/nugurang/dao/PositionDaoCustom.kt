package com.nugurang.dao

import com.nugurang.entity.PositionEntity

interface PositionDaoCustom {
    fun findAllByTaskId(task: Long): List<PositionEntity>
    fun findAllByUserIdAndTaskId(user: Long, task: Long): List<PositionEntity>
}