package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class FollowingDto {
    @NotNull
    private Long id;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class FollowingDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;

        @SuppressWarnings("all")
        
        FollowingDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public FollowingDto.FollowingDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public FollowingDto build() {
            return new FollowingDto(this.id);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "FollowingDto.FollowingDtoBuilder(id=" + this.id + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static FollowingDto.FollowingDtoBuilder builder() {
        return new FollowingDto.FollowingDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FollowingDto)) return false;
        final FollowingDto other = (FollowingDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof FollowingDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "FollowingDto(id=" + this.getId() + ")";
    }

    @SuppressWarnings("all")
    
    public FollowingDto(final Long id) {
        this.id = id;
    }
    //</editor-fold>
}
