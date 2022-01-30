package com.nugurang.dao

import com.nugurang.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleDao : JpaRepository<RoleEntity, Long> {
    fun findByName(name: String): RoleEntity?
}