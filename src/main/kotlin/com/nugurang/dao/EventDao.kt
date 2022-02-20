package com.nugurang.dao

import com.nugurang.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventDao : JpaRepository<EventEntity, Long>