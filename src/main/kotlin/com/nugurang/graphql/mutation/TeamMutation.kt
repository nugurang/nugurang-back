package com.nugurang.graphql.mutation

import com.nugurang.dto.TeamDto
import com.nugurang.dto.TeamInputDto
import com.nugurang.mapper.TeamMapper
import com.nugurang.service.TeamService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class TeamMutation(
    private val teamService: TeamService,
    private val teamMapper: TeamMapper
) : GraphQLMutationResolver {
    fun createTeam(teamInputDto: TeamInputDto): TeamDto {
        return teamService
            .createTeam(teamInputDto)
            .let(teamMapper::toDto)
    }

    fun updateTeam(teamInputDto: TeamInputDto, teamId: Long): TeamDto {
        return teamService
            .updateTeam(teamInputDto, teamId)
            .let(teamMapper::toDto)
    }

    fun deleteTeam(teamId: Long): Long {
        teamService.deleteTeam(teamId)
        return teamId
    }
}