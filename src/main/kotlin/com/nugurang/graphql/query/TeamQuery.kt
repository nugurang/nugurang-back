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
        return teamService.getTeam(id).let(teamMapper::toDto)
    }

    fun getTeamByName(name: String): TeamDto {
        return teamService.getTeam(name).let(teamMapper::toDto)
    }

    fun getTeamsByName(name: String, page: Int, pageSize: Int): List<TeamDto> {
        return teamService.getTeams(name, PageRequest.of(page, pageSize)).map(teamMapper::toDto)
    }
}