package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class UserReviewDto {
    @NotNull
    private Long id;
    @NotNull
    private Integer honor;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserReviewDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private Integer honor;

        @SuppressWarnings("all")
        
        UserReviewDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserReviewDto.UserReviewDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewDto.UserReviewDtoBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewDto build() {
            return new UserReviewDto(this.id, this.honor);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserReviewDto.UserReviewDtoBuilder(id=" + this.id + ", honor=" + this.honor + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserReviewDto.UserReviewDtoBuilder builder() {
        return new UserReviewDto.UserReviewDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public Integer getHonor() {
        return this.honor;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setHonor(final Integer honor) {
        this.honor = honor;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserReviewDto)) return false;
        final UserReviewDto other = (UserReviewDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$honor = this.getHonor();
        final Object other$honor = other.getHonor();
        if (this$honor == null ? other$honor != null : !this$honor.equals(other$honor)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof UserReviewDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $honor = this.getHonor();
        result = result * PRIME + ($honor == null ? 43 : $honor.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "UserReviewDto(id=" + this.getId() + ", honor=" + this.getHonor() + ")";
    }

    @SuppressWarnings("all")
    
    public UserReviewDto(final Long id, final Integer honor) {
        this.id = id;
        this.honor = honor;
    }
    //</editor-fold>
}
