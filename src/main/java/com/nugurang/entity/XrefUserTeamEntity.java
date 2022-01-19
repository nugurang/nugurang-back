package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_user_team", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "team"})})
public class XrefUserTeamEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private TeamEntity team;
    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    public XrefUserTeamEntity(UserEntity user, TeamEntity team, RoleEntity role) {
        this.user = user;
        this.team = team;
        this.role = role;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefUserTeamEntityBuilder {
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private TeamEntity team;
        @SuppressWarnings("all")
        
        private RoleEntity role;

        @SuppressWarnings("all")
        
        XrefUserTeamEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefUserTeamEntity.XrefUserTeamEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserTeamEntity.XrefUserTeamEntityBuilder team(final TeamEntity team) {
            this.team = team;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserTeamEntity.XrefUserTeamEntityBuilder role(final RoleEntity role) {
            this.role = role;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserTeamEntity build() {
            return new XrefUserTeamEntity(this.user, this.team, this.role);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefUserTeamEntity.XrefUserTeamEntityBuilder(user=" + this.user + ", team=" + this.team + ", role=" + this.role + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefUserTeamEntity.XrefUserTeamEntityBuilder builder() {
        return new XrefUserTeamEntity.XrefUserTeamEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected XrefUserTeamEntity() {
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
    
    public TeamEntity getTeam() {
        return this.team;
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
    
    public void setTeam(final TeamEntity team) {
        this.team = team;
    }

    @SuppressWarnings("all")
    
    public void setRole(final RoleEntity role) {
        this.role = role;
    }
    //</editor-fold>
}
