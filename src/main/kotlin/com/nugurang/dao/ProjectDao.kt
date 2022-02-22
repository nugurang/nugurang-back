package com.nugurang.dao

import com.nugurang.entity.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectDao : JpaRepository<ProjectEntity, Long>, ProjectDaoCustom {
    fun findByUserEvaluationId(userEvaluation: Long): ProjectEntity?
    fun findAllByTeamId(team: Long): List<ProjectEntity>
}