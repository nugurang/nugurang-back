package com.nugurang.graphql.resolver

import com.nugurang.constant.RoleName
import com.nugurang.dao.ProjectDao
import com.nugurang.dao.RoleDao
import com.nugurang.dao.UserDao
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.TeamDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.UserEntity
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TeamResolver(
    private val roleDao: RoleDao,
    private val projectDao: ProjectDao,
    private val userDao: UserDao
) : GraphQLResolver<TeamDto> {
    fun projects(teamDto: TeamDto): List<ProjectDto> {
        return projectDao.findAllByTeamId(teamDto.id).stream().map { entity: ProjectEntity -> entity.toDto() }
            .collect(Collectors.toList())
    }

    fun owner(teamDto: TeamDto): UserDto {
        return userDao.findFirstByTeamIdAndRoleId(teamDto.id, roleDao.findByName(RoleName.OWNER.name)!!.id)!!.toDto()
    }

    fun getMembers(teamDto: TeamDto, page: Int?, pageSize: Int?): List<UserDto> {
        return userDao.findAllByTeamIdAndRoleId(
            teamDto.id, roleDao.findByName(RoleName.MEMBER.name)!!.id, PageRequest.of(
                page!!, pageSize!!
            )
        ).content.stream().map { entity: UserEntity -> entity.toDto() }.collect(Collectors.toList())
    }
}