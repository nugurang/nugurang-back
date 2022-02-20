package com.nugurang.dao

import com.nugurang.entity.TeamInvitationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamInvitationDao : JpaRepository<TeamInvitationEntity, Long>