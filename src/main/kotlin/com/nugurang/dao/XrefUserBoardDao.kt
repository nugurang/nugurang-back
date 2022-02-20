package com.nugurang.dao

import com.nugurang.entity.XrefUserBoardEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefUserBoardDao : JpaRepository<XrefUserBoardEntity, Long>