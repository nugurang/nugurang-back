package com.nugurang.dao

import com.nugurang.entity.UserHonorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserHonorDao : JpaRepository<UserHonorEntity, Long> {
    fun findAllByUserId(user: Long): List<UserHonorEntity>
    fun findByUserIdAndPositionId(user: Long, position: Long): UserHonorEntity?
}