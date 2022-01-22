package com.nugurang.entity;

import com.nugurang.dto.ProjectInvitationDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "project_invitation", uniqueConstraints = @UniqueConstraint(columnNames = {"project", "from_user", "to_user"}))
public class ProjectInvitationEntity implements BaseEntity<ProjectInvitationDto> {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "status")
    private InvitationStatusEntity status;
    @ManyToOne
    @JoinColumn(name = "project")
    private ProjectEntity project;
    @ManyToOne
    @JoinColumn(name = "from_user")
    private UserEntity fromUser;
    @ManyToOne
    @JoinColumn(name = "to_user")
    private UserEntity toUser;

    @Override
    public ProjectInvitationDto toDto() {
        return new ProjectInvitationDto(id);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ProjectInvitationEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private InvitationStatusEntity status;
        @SuppressWarnings("all")
        
        private ProjectEntity project;
        @SuppressWarnings("all")
        
        private UserEntity fromUser;
        @SuppressWarnings("all")
        
        private UserEntity toUser;

        @SuppressWarnings("all")
        
        ProjectInvitationEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationEntity.ProjectInvitationEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationEntity.ProjectInvitationEntityBuilder status(final InvitationStatusEntity status) {
            this.status = status;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationEntity.ProjectInvitationEntityBuilder project(final ProjectEntity project) {
            this.project = project;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationEntity.ProjectInvitationEntityBuilder fromUser(final UserEntity fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationEntity.ProjectInvitationEntityBuilder toUser(final UserEntity toUser) {
            this.toUser = toUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInvitationEntity build() {
            return new ProjectInvitationEntity(this.id, this.status, this.project, this.fromUser, this.toUser);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ProjectInvitationEntity.ProjectInvitationEntityBuilder(id=" + this.id + ", status=" + this.status + ", project=" + this.project + ", fromUser=" + this.fromUser + ", toUser=" + this.toUser + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ProjectInvitationEntity.ProjectInvitationEntityBuilder builder() {
        return new ProjectInvitationEntity.ProjectInvitationEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public InvitationStatusEntity getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    
    public ProjectEntity getProject() {
        return this.project;
    }

    @SuppressWarnings("all")
    
    public UserEntity getFromUser() {
        return this.fromUser;
    }

    @SuppressWarnings("all")
    
    public UserEntity getToUser() {
        return this.toUser;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setStatus(final InvitationStatusEntity status) {
        this.status = status;
    }

    @SuppressWarnings("all")
    
    public void setProject(final ProjectEntity project) {
        this.project = project;
    }

    @SuppressWarnings("all")
    
    public void setFromUser(final UserEntity fromUser) {
        this.fromUser = fromUser;
    }

    @SuppressWarnings("all")
    
    public void setToUser(final UserEntity toUser) {
        this.toUser = toUser;
    }

    @SuppressWarnings("all")
    
    public ProjectInvitationEntity(final Long id, final InvitationStatusEntity status, final ProjectEntity project, final UserEntity fromUser, final UserEntity toUser) {
        this.id = id;
        this.status = status;
        this.project = project;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    @SuppressWarnings("all")
    
    protected ProjectInvitationEntity() {
    }
    //</editor-fold>
}
