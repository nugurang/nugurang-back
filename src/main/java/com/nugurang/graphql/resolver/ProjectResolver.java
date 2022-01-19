package com.nugurang.graphql.resolver;

import com.nugurang.dao.EventDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProjectResolver implements GraphQLResolver<ProjectDto> {
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final UserDao userDao;
    private final EventDao eventDao;
    private final WorkDao workDao;

    public TeamDto team(ProjectDto projectDto) {
        return projectDao.findById(projectDto.getId()).get().getTeam().toDto();
    }

    public List<UserDto> getUsers(ProjectDto projectDto, Integer page, Integer pageSize) {
        return userDao.findAllByProjectId(projectDto.getId(), PageRequest.of(page, pageSize)).stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    public Optional<EventDto> event(ProjectDto projectDto) {
        return projectDao.findById(projectDto.getId()).map(projectEntity -> projectEntity.getEvent()).map(entity -> entity.toDto());
    }

    public List<WorkDto> works(ProjectDto projectDto) {
        return workDao.findAllByProjectId(projectDto.getId()).stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ProjectResolver(final ProjectDao projectDao, final TeamDao teamDao, final UserDao userDao, final EventDao eventDao, final WorkDao workDao) {
        this.projectDao = projectDao;
        this.teamDao = teamDao;
        this.userDao = userDao;
        this.eventDao = eventDao;
        this.workDao = workDao;
    }
    //</editor-fold>
}
