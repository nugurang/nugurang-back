package com.nugurang.dao

import com.nugurang.entity.XrefUserTaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefUserTaskDao : JpaRepository<XrefUserTaskEntity, Long>