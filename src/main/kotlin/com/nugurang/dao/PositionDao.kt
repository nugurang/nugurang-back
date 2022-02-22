package com.nugurang.dao

import com.nugurang.entity.PositionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PositionDao : JpaRepository<PositionEntity, Long>, PositionDaoCustom