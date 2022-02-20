package com.nugurang.dao

import com.nugurang.entity.TeamEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TeamDaoCustom {
    fun findAllByUserId(user: Long, pageable: Pageable): Page<TeamEntity>
}