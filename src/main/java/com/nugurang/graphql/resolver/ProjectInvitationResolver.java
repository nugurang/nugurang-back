package com.nugurang.graphql.resolver;

import com.nugurang.dao.ProjectInvitationDao;
import com.nugurang.dto.InvitationStatusDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.ProjectInvitationDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class ProjectInvitationResolver implements GraphQLResolver<ProjectInvitationDto> {
    private final ProjectInvitationDao projectInvitationDao;

    public ProjectDto project(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao.findById(projectInvitationDto.getId()).get().getProject().toDto();
    }

    public InvitationStatusDto status(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao.findById(projectInvitationDto.getId()).get().getStatus().toDto();
    }

    public UserDto fromUser(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao.findById(projectInvitationDto.getId()).get().getFromUser().toDto();
    }

    public UserDto toUser(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao.findById(projectInvitationDto.getId()).get().getToUser().toDto();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ProjectInvitationResolver(final ProjectInvitationDao projectInvitationDao) {
        this.projectInvitationDao = projectInvitationDao;
    }
    //</editor-fold>
}
