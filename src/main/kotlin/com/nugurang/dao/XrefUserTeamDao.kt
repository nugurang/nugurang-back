package com.nugurang.dao

import com.nugurang.entity.XrefUserTeamEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefUserTeamDao : JpaRepository<XrefUserTeamEntity, Long> {
    fun findByUserIdAndTeamId(user: Long, team: Long): XrefUserTeamEntity?
    fun deleteAllByTeamId(team: Long)
}