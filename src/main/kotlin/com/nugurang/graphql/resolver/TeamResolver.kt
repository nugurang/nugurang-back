package com.nugurang.graphql.resolver

import com.nugurang.constant.RoleName
import com.nugurang.dao.ProjectDao
import com.nugurang.dao.RoleDao
import com.nugurang.dao.UserDao
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.TeamDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.RoleEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.ProjectMapper
import com.nugurang.mapper.UserMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class TeamResolver(
    private val roleDao: RoleDao,
    private val projectDao: ProjectDao,
    private val userDao: UserDao,
    private val projectMapper: ProjectMapper,
    private val userMapper: UserMapper
) : GraphQLResolver<TeamDto> {

    fun projects(teamDto: TeamDto): List<ProjectDto> {
        return projectDao.findAllByTeamId(teamDto.id).map(projectMapper::toDto)
    }

    fun owner(teamDto: TeamDto): UserDto {
        return userDao
            .findFirstByTeamIdAndRoleId(
                teamDto.id,
                roleDao.findByName(RoleName.OWNER.name)?.id
                ?: throw NotFoundException(RoleEntity::class.java)
            )
            ?.let(userMapper::toDto)
            ?: throw NotFoundException(UserEntity::class.java)
    }

    fun getMembers(teamDto: TeamDto, page: Int, pageSize: Int): List<UserDto> {
        return userDao.findAllByTeamIdAndRoleId(
            teamDto.id,
            roleDao.findByName(RoleName.MEMBER.name)?.id ?: throw NotFoundException(RoleEntity::class.java),
            PageRequest.of(page, pageSize)
        )
        .content
        .asSequence()
        .map(userMapper::toDto)
        .toList()
    }
}