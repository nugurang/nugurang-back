package com.nugurang.graphql.mutation;

import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.ProjectInputDto;
import com.nugurang.service.ProjectService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

@Service
public class ProjectMutation implements GraphQLMutationResolver {
    private final ProjectService projectService;

    public ProjectDto createProject(ProjectInputDto projectInputDto, Long team) {
        return projectService.createProject(projectInputDto, team).toDto();
    }

    public ProjectDto updateProject(ProjectInputDto projectInputDto, Long id) {
        return projectService.updateProject(projectInputDto, id).toDto();
    }

    public Long deleteProject(Long id) {
        projectService.deleteProject(id);
        return id;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ProjectMutation(final ProjectService projectService) {
        this.projectService = projectService;
    }
    //</editor-fold>
}
