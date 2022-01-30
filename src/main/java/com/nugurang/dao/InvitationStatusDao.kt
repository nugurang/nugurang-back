package com.nugurang.dao

import com.nugurang.entity.InvitationStatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvitationStatusDao : JpaRepository<InvitationStatusEntity, Long> {
    fun findByName(name: String): InvitationStatusEntity?
}