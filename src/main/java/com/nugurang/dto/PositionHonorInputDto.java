package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class PositionHonorInputDto {
    @NotNull
    private Long position;
    @NotNull
    private Integer honor;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class PositionHonorInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Long position;
        @SuppressWarnings("all")
        
        private Integer honor;

        @SuppressWarnings("all")
        
        PositionHonorInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public PositionHonorInputDto.PositionHonorInputDtoBuilder position(final Long position) {
            this.position = position;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionHonorInputDto.PositionHonorInputDtoBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionHonorInputDto build() {
            return new PositionHonorInputDto(this.position, this.honor);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "PositionHonorInputDto.PositionHonorInputDtoBuilder(position=" + this.position + ", honor=" + this.honor + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static PositionHonorInputDto.PositionHonorInputDtoBuilder builder() {
        return new PositionHonorInputDto.PositionHonorInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getPosition() {
        return this.position;
    }

    @SuppressWarnings("all")
    
    public Integer getHonor() {
        return this.honor;
    }

    @SuppressWarnings("all")
    
    public void setPosition(final Long position) {
        this.position = position;
    }

    @SuppressWarnings("all")
    
    public void setHonor(final Integer honor) {
        this.honor = honor;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PositionHonorInputDto)) return false;
        final PositionHonorInputDto other = (PositionHonorInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
        final Object this$honor = this.getHonor();
        final Object other$honor = other.getHonor();
        if (this$honor == null ? other$honor != null : !this$honor.equals(other$honor)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof PositionHonorInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $position = this.getPosition();
        result = result * PRIME + ($position == null ? 43 : $position.hashCode());
        final Object $honor = this.getHonor();
        result = result * PRIME + ($honor == null ? 43 : $honor.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "PositionHonorInputDto(position=" + this.getPosition() + ", honor=" + this.getHonor() + ")";
    }

    @SuppressWarnings("all")
    
    public PositionHonorInputDto(final Long position, final Integer honor) {
        this.position = position;
        this.honor = honor;
    }
    //</editor-fold>
}
