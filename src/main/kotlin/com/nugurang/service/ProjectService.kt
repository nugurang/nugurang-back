package com.nugurang.service

import com.nugurang.annotation.DaoOp
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
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Validated
@Service
class ProjectService(
    private val eventDao: EventDao,
    private val roleDao: RoleDao,
    private val projectDao: ProjectDao,
    private val teamDao: TeamDao,
    private val userService: UserService,
    private val xrefUserProjectDao: XrefUserProjectDao
) {

    @DaoOp
    fun createProject(@Valid projectInputDto: ProjectInputDto, teamId: Long): ProjectEntity {
        val projectEntity = projectDao.save(
            ProjectEntity(
                name = projectInputDto.name,
                finished = false,
                team = teamDao.findByIdOrNull(teamId) ?: throw NotFoundException(TeamEntity::class.java),
                event = projectInputDto.event?.let(eventDao::findByIdOrNull)
            )
        )

        xrefUserProjectDao.save(
            XrefUserProjectEntity(
                user = userService.getCurrentUser(),
                project = projectEntity,
                role = roleDao.findByName(RoleName.OWNER.name)
                    ?: throw NotFoundException(RoleEntity::class.java)
            )
        )
        return projectEntity
    }

    fun getProject(projectId: Long): ProjectEntity {
        return projectDao.findByIdOrNull(projectId) ?: throw NotFoundException(ProjectEntity::class.java)
    }

    @DaoOp
    fun updateProject(@Valid projectInputDto: ProjectInputDto, projectId: Long): ProjectEntity {
        return projectDao.save(
            projectDao.findByIdOrNull(projectId)?.let { projectEntity ->
                projectEntity.name = projectInputDto.name
                projectEntity.event = projectInputDto.event?.let(eventDao::findByIdOrNull)
                projectEntity
            } ?: throw NotFoundException(ProjectEntity::class.java)
        )
    }

    @DaoOp
    fun deleteProject(projectId: Long) {
        projectDao.deleteById(projectId)
    }
}