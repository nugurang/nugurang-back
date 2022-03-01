package com.nugurang.graphql.query

import com.nugurang.dto.TeamDto
import com.nugurang.mapper.TeamMapper
import com.nugurang.service.TeamService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class TeamQuery(
    private val teamService: TeamService,
    private val teamMapper: TeamMapper
) : GraphQLQueryResolver {
    fun getTeam(id: Long): TeamDto {
        return teamMapper.toDto(teamService.getTeam(id))
    }

    fun getTeamByName(name: String): TeamDto {
        return teamMapper.toDto(teamService.getTeam(name))
    }

    fun getTeamsByName(name: String, page: Int, pageSize: Int): List<TeamDto> {
        return teamService.getTeams(name, PageRequest.of(page, pageSize)).map(teamMapper::toDto)
    }
}