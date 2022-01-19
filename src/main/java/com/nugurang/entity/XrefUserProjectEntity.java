package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_user_project", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "project"})})
public class XrefUserProjectEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private ProjectEntity project;
    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    public XrefUserProjectEntity(UserEntity user, ProjectEntity project, RoleEntity role) {
        this.user = user;
        this.project = project;
        this.role = role;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefUserProjectEntityBuilder {
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private ProjectEntity project;
        @SuppressWarnings("all")
        
        private RoleEntity role;

        @SuppressWarnings("all")
        
        XrefUserProjectEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefUserProjectEntity.XrefUserProjectEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserProjectEntity.XrefUserProjectEntityBuilder project(final ProjectEntity project) {
            this.project = project;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserProjectEntity.XrefUserProjectEntityBuilder role(final RoleEntity role) {
            this.role = role;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserProjectEntity build() {
            return new XrefUserProjectEntity(this.user, this.project, this.role);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefUserProjectEntity.XrefUserProjectEntityBuilder(user=" + this.user + ", project=" + this.project + ", role=" + this.role + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefUserProjectEntity.XrefUserProjectEntityBuilder builder() {
        return new XrefUserProjectEntity.XrefUserProjectEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected XrefUserProjectEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    
    public ProjectEntity getProject() {
        return this.project;
    }

    @SuppressWarnings("all")
    
    public RoleEntity getRole() {
        return this.role;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    
    public void setProject(final ProjectEntity project) {
        this.project = project;
    }

    @SuppressWarnings("all")
    
    public void setRole(final RoleEntity role) {
        this.role = role;
    }
    //</editor-fold>
}
