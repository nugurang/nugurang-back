package com.nugurang.service

import com.nugurang.constant.RoleName
import com.nugurang.dao.*
import com.nugurang.dto.ProjectInputDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.XrefUserProjectEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ProjectService(
    private val eventDao: EventDao,
    private val roleDao: RoleDao,
    private val projectDao: ProjectDao,
    private val teamDao: TeamDao,
    private val userService: UserService,
    private val xrefUserProjectDao: XrefUserProjectDao
) {
    @Transactional
    fun createProject(projectInputDto: ProjectInputDto, teamId: Long): ProjectEntity {
        val projectEntity = projectDao.save(ProjectEntity.builder().name(projectInputDto.name).finished(false).team(
            teamDao.findById(teamId).get()
        ).event(Optional.ofNullable(projectInputDto.event).flatMap { id: Long -> eventDao.findById(id) }
            .orElse(null)).build())
        xrefUserProjectDao.save(
            XrefUserProjectEntity.builder().user(userService.getCurrentUser()).project(projectEntity).role(
                roleDao.findByName(RoleName.OWNER.name)
            ).build()
        )
        return projectEntity
    }

    fun getProject(projectId: Long): Optional<ProjectEntity> {
        return projectDao.findById(projectId)
    }

    @Transactional
    fun updateProject(projectInputDto: ProjectInputDto, projectId: Long): ProjectEntity {
        return projectDao.save(projectDao.findById(projectId).map { projectEntity: ProjectEntity ->
            projectEntity.name = projectInputDto.name
            projectEntity.event =
                Optional.ofNullable(projectInputDto.event).flatMap { eventId: Long -> eventDao.findById(eventId) }
                    .orElse(null)
            projectEntity
        }.get())
    }

    fun deleteProject(projectId: Long) {
        projectDao.deleteById(projectId)
    }
}