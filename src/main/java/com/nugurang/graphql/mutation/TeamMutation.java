package com.nugurang.graphql.mutation;

import com.nugurang.dto.TeamDto;
import com.nugurang.dto.TeamInputDto;
import com.nugurang.service.TeamService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

@Service
public class TeamMutation implements GraphQLMutationResolver {
    private final TeamService teamService;

    public TeamDto createTeam(TeamInputDto teamInputDto) {
        return teamService.createTeam(teamInputDto).toDto();
    }

    public TeamDto updateTeam(TeamInputDto teamInputDto, Long teamId) {
        return teamService.updateTeam(teamInputDto, teamId).toDto();
    }

    public Long deleteTeam(Long teamId) {
        teamService.deleteTeam(teamId);
        return teamId;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public TeamMutation(final TeamService teamService) {
        this.teamService = teamService;
    }
    //</editor-fold>
}
