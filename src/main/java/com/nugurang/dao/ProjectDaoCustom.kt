package com.nugurang.dao

import com.nugurang.entity.ProjectEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProjectDaoCustom {
    fun findAllByUserId(user: Long, pageable: Pageable): Page<ProjectEntity>
}