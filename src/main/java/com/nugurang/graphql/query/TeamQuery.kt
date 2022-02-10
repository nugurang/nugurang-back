package com.nugurang.graphql.query

import com.nugurang.dto.TeamDto
import com.nugurang.service.TeamService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class TeamQuery(private val teamService: TeamService) : GraphQLQueryResolver {
    fun getTeam(id: Long): TeamDto {
        return teamService.getTeam(id).toDto()
    }

    fun getTeamByName(name: String): TeamDto {
        return teamService.getTeam(name).toDto()
    }

    fun getTeamsByName(name: String, page: Int, pageSize: Int): List<TeamDto> {
        return teamService.getTeams(name, PageRequest.of(page, pageSize)).map { it.toDto() }
    }
}