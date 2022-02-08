package com.nugurang.service

import com.nugurang.constant.RoleName
import com.nugurang.dao.*
import com.nugurang.dto.ProjectInputDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.RoleEntity
import com.nugurang.entity.TeamEntity
import com.nugurang.entity.XrefUserProjectEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
        val projectEntity = projectDao.save(
            ProjectEntity
            .builder()
            .name(projectInputDto.name)
            .finished(false)
            .team(teamDao.findByIdOrNull(teamId) ?: throw NotFoundException(TeamEntity::class.java))
            .event(eventDao.findByIdOrNull(projectInputDto.event))
            .build()
        )

        xrefUserProjectDao.save(
            XrefUserProjectEntity
            .builder()
            .user(userService.getCurrentUser())
            .project(projectEntity)
            .role(
                roleDao.findByName(RoleName.OWNER.name)
                ?: throw NotFoundException(RoleEntity::class.java)
            )
            .build()
        )
        return projectEntity
    }

    fun getProject(projectId: Long): ProjectEntity {
        return projectDao.findByIdOrNull(projectId) ?: throw NotFoundException(ProjectEntity::class.java)
    }

    @Transactional
    fun updateProject(projectInputDto: ProjectInputDto, projectId: Long): ProjectEntity {
        return projectDao.save(
            projectDao.findByIdOrNull(projectId)?.let { projectEntity ->
                projectEntity.name = projectInputDto.name
                projectEntity.event = eventDao.findByIdOrNull(projectInputDto.event)
                projectEntity
            } ?: throw NotFoundException(ProjectEntity::class.java)
        )
    }

    fun deleteProject(projectId: Long) {
        projectDao.deleteById(projectId)
    }
}