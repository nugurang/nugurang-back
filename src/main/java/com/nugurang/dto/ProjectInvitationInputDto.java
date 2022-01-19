package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

public class ProjectInvitationInputDto {
    @NotNull
    private Long project;
    @NotNull
    private List<Long> users;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ProjectInvitationInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Long project;
        @SuppressWarnings("all")
        
        private List<Long> users;

        @SuppressWarnings("all")
        
        ProjectInvitationInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationInputDto.ProjectInvitationInputDtoBuilder project(final Long project) {
            this.project = project;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationInputDto.ProjectInvitationInputDtoBuilder users(final List<Long> users) {
            this.users = users;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationInputDto build() {
            return new ProjectInvitationInputDto(this.project, this.users);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ProjectInvitationInputDto.ProjectInvitationInputDtoBuilder(project=" + this.project + ", users=" + this.users + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ProjectInvitationInputDto.ProjectInvitationInputDtoBuilder builder() {
        return new ProjectInvitationInputDto.ProjectInvitationInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getProject() {
        return this.project;
    }

    @SuppressWarnings("all")
    
    public List<Long> getUsers() {
        return this.users;
    }

    @SuppressWarnings("all")
    
    public void setProject(final Long project) {
        this.project = project;
    }

    @SuppressWarnings("all")
    
    public void setUsers(final List<Long> users) {
        this.users = users;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProjectInvitationInputDto)) return false;
        final ProjectInvitationInputDto other = (ProjectInvitationInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$project = this.getProject();
        final Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) return false;
        final Object this$users = this.getUsers();
        final Object other$users = other.getUsers();
        if (this$users == null ? other$users != null : !this$users.equals(other$users)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ProjectInvitationInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $project = this.getProject();
        result = result * PRIME + ($project == null ? 43 : $project.hashCode());
        final Object $users = this.getUsers();
        result = result * PRIME + ($users == null ? 43 : $users.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ProjectInvitationInputDto(project=" + this.getProject() + ", users=" + this.getUsers() + ")";
    }

    @SuppressWarnings("all")
    
    public ProjectInvitationInputDto(final Long project, final List<Long> users) {
        this.project = project;
        this.users = users;
    }
    //</editor-fold>
}
