package com.nugurang.dao

import com.nugurang.entity.XrefEventTagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefEventTagDao : JpaRepository<XrefEventTagEntity, Long>