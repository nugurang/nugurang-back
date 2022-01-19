package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

public class UserReviewInputDto {
    @NotNull
    private Long toUser;
    @NotNull
    private List<PositionHonorInputDto> honors;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserReviewInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Long toUser;
        @SuppressWarnings("all")
        
        private List<PositionHonorInputDto> honors;

        @SuppressWarnings("all")
        
        UserReviewInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserReviewInputDto.UserReviewInputDtoBuilder toUser(final Long toUser) {
            this.toUser = toUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewInputDto.UserReviewInputDtoBuilder honors(final List<PositionHonorInputDto> honors) {
            this.honors = honors;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewInputDto build() {
            return new UserReviewInputDto(this.toUser, this.honors);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserReviewInputDto.UserReviewInputDtoBuilder(toUser=" + this.toUser + ", honors=" + this.honors + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserReviewInputDto.UserReviewInputDtoBuilder builder() {
        return new UserReviewInputDto.UserReviewInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getToUser() {
        return this.toUser;
    }

    @SuppressWarnings("all")
    
    public List<PositionHonorInputDto> getHonors() {
        return this.honors;
    }

    @SuppressWarnings("all")
    
    public void setToUser(final Long toUser) {
        this.toUser = toUser;
    }

    @SuppressWarnings("all")
    
    public void setHonors(final List<PositionHonorInputDto> honors) {
        this.honors = honors;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserReviewInputDto)) return false;
        final UserReviewInputDto other = (UserReviewInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$toUser = this.getToUser();
        final Object other$toUser = other.getToUser();
        if (this$toUser == null ? other$toUser != null : !this$toUser.equals(other$toUser)) return false;
        final Object this$honors = this.getHonors();
        final Object other$honors = other.getHonors();
        if (this$honors == null ? other$honors != null : !this$honors.equals(other$honors)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof UserReviewInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $toUser = this.getToUser();
        result = result * PRIME + ($toUser == null ? 43 : $toUser.hashCode());
        final Object $honors = this.getHonors();
        result = result * PRIME + ($honors == null ? 43 : $honors.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "UserReviewInputDto(toUser=" + this.getToUser() + ", honors=" + this.getHonors() + ")";
    }

    @SuppressWarnings("all")
    
    public UserReviewInputDto(final Long toUser, final List<PositionHonorInputDto> honors) {
        this.toUser = toUser;
        this.honors = honors;
    }
    //</editor-fold>
}
