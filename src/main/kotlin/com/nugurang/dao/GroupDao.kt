package com.nugurang.dao

import com.nugurang.entity.GroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupDao : JpaRepository<GroupEntity, Long> {
}