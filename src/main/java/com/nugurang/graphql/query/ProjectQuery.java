package com.nugurang.graphql.query;

import com.nugurang.dto.ProjectDto;
import com.nugurang.service.ProjectService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProjectQuery implements GraphQLQueryResolver {
    private final ProjectService projectService;

    public Optional<ProjectDto> getProject(Long id) {
        return Optional.ofNullable(projectService.getProject(id)).map(entity -> entity.toDto());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ProjectQuery(final ProjectService projectService) {
        this.projectService = projectService;
    }
    //</editor-fold>
}
