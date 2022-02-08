package com.nugurang.graphql.mutation

import com.nugurang.dto.TeamDto
import com.nugurang.dto.TeamInputDto
import com.nugurang.service.TeamService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class TeamMutation(private val teamService: TeamService) : GraphQLMutationResolver {
    fun createTeam(teamInputDto: TeamInputDto): TeamDto {
        return teamService.createTeam(teamInputDto).toDto()
    }

    fun updateTeam(teamInputDto: TeamInputDto, teamId: Long): TeamDto {
        return teamService.updateTeam(teamInputDto, teamId).toDto()
    }

    fun deleteTeam(teamId: Long): Long {
        teamService.deleteTeam(teamId)
        return teamId
    }
}