package com.nugurang.dao

import com.nugurang.entity.InvitationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvitationDao : JpaRepository<InvitationEntity, Long>