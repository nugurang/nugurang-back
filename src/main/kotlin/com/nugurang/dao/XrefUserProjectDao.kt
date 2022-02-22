package com.nugurang.dao

import com.nugurang.entity.XrefUserProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefUserProjectDao : JpaRepository<XrefUserProjectEntity, Long>