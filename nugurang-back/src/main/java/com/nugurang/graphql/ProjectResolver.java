package com.nugurang.graphql;

import com.nugurang.dao.EventDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectResolver implements GraphQLResolver<ProjectDto> {
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final EventDao eventDao;
    private final WorkDao workDao;

    public TeamDto team(ProjectDto projectDto) {
        return projectDao
            .findById(projectDto.getId())
            .get()
            .getTeam()
            .toDto();
    }

    public List<UserDto> users(ProjectDto projectDto) {
        return null;
    }

    public EventDto event(ProjectDto projectDto) {
        return null;
    }

    public List<WorkDto> getWorks(ProjectDto projectDto, Integer page, Integer pageSize) {
        return null;
    }
}
