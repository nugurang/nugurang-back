package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

public class TeamInvitationInputDto {
    @NotNull
    private Long team;
    @NotNull
    private List<Long> users;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TeamInvitationInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Long team;
        @SuppressWarnings("all")
        
        private List<Long> users;

        @SuppressWarnings("all")
        
        TeamInvitationInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public TeamInvitationInputDto.TeamInvitationInputDtoBuilder team(final Long team) {
            this.team = team;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationInputDto.TeamInvitationInputDtoBuilder users(final List<Long> users) {
            this.users = users;
            return this;
        }

        @SuppressWarnings("all")
        
        public TeamInvitationInputDto build() {
            return new TeamInvitationInputDto(this.team, this.users);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TeamInvitationInputDto.TeamInvitationInputDtoBuilder(team=" + this.team + ", users=" + this.users + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TeamInvitationInputDto.TeamInvitationInputDtoBuilder builder() {
        return new TeamInvitationInputDto.TeamInvitationInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getTeam() {
        return this.team;
    }

    @SuppressWarnings("all")
    
    public List<Long> getUsers() {
        return this.users;
    }

    @SuppressWarnings("all")
    
    public void setTeam(final Long team) {
        this.team = team;
    }

    @SuppressWarnings("all")
    
    public void setUsers(final List<Long> users) {
        this.users = users;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TeamInvitationInputDto)) return false;
        final TeamInvitationInputDto other = (TeamInvitationInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$team = this.getTeam();
        final Object other$team = other.getTeam();
        if (this$team == null ? other$team != null : !this$team.equals(other$team)) return false;
        final Object this$users = this.getUsers();
        final Object other$users = other.getUsers();
        if (this$users == null ? other$users != null : !this$users.equals(other$users)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof TeamInvitationInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $team = this.getTeam();
        result = result * PRIME + ($team == null ? 43 : $team.hashCode());
        final Object $users = this.getUsers();
        result = result * PRIME + ($users == null ? 43 : $users.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "TeamInvitationInputDto(team=" + this.getTeam() + ", users=" + this.getUsers() + ")";
    }

    @SuppressWarnings("all")
    
    public TeamInvitationInputDto(final Long team, final List<Long> users) {
        this.team = team;
        this.users = users;
    }
    //</editor-fold>
}
