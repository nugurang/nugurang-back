package com.nugurang.entity;

import com.nugurang.dto.TeamInvitationDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "team_invitation", uniqueConstraints = @UniqueConstraint(columnNames = {"team", "from_user", "to_user"}))
public class TeamInvitationEntity implements BaseEntity<TeamInvitationDto> {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "status")
    private InvitationStatusEntity status;
    @ManyToOne
    @JoinColumn(name = "team")
    private TeamEntity team;
    @ManyToOne
    @JoinColumn(name = "from_user")
    private UserEntity fromUser;
    @ManyToOne
    @JoinColumn(name = "to_user")
    private UserEntity toUser;

    @Override
    public TeamInvitationDto toDto() {
        return TeamInvitationDto.builder().id(id).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TeamInvitationEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private InvitationStatusEntity status;
        @SuppressWarnings("all")
        
        private TeamEntity team;
        @SuppressWarnings("all")
        
        private UserEntity fromUser;
        @SuppressWarnings("all")
        
        private UserEntity toUser;

        @SuppressWarnings("all")
        
        TeamInvitationEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public TeamInvitationEntity.TeamInvitationEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationEntity.TeamInvitationEntityBuilder status(final InvitationStatusEntity status) {
            this.status = status;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationEntity.TeamInvitationEntityBuilder team(final TeamEntity team) {
            this.team = team;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationEntity.TeamInvitationEntityBuilder fromUser(final UserEntity fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationEntity.TeamInvitationEntityBuilder toUser(final UserEntity toUser) {
            this.toUser = toUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationEntity build() {
            return new TeamInvitationEntity(this.id, this.status, this.team, this.fromUser, this.toUser);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TeamInvitationEntity.TeamInvitationEntityBuilder(id=" + this.id + ", status=" + this.status + ", team=" + this.team + ", fromUser=" + this.fromUser + ", toUser=" + this.toUser + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TeamInvitationEntity.TeamInvitationEntityBuilder builder() {
        return new TeamInvitationEntity.TeamInvitationEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public TeamInvitationEntity(final Long id, final InvitationStatusEntity status, final TeamEntity team, final UserEntity fromUser, final UserEntity toUser) {
        this.id = id;
        this.status = status;
        this.team = team;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    @SuppressWarnings("all")
    
    protected TeamInvitationEntity() {
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
    
    public TeamEntity getTeam() {
        return this.team;
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
    
    public void setTeam(final TeamEntity team) {
        this.team = team;
    }

    @SuppressWarnings("all")
    
    public void setFromUser(final UserEntity fromUser) {
        this.fromUser = fromUser;
    }

    @SuppressWarnings("all")
    
    public void setToUser(final UserEntity toUser) {
        this.toUser = toUser;
    }
    //</editor-fold>
}
