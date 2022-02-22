package com.nugurang.dao

import com.nugurang.entity.TeamEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamDao : JpaRepository<TeamEntity, Long>, TeamDaoCustom {
    fun findByName(name: String): TeamEntity?
    fun findAllByNameContainingIgnoreCase(name: String, pageable: Pageable): Page<TeamEntity>
}