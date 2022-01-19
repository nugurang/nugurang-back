package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class ImageDto {
    @NotNull
    private Long id;
    @NotNull
    private String address;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ImageDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String address;

        @SuppressWarnings("all")
        
        ImageDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ImageDto.ImageDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ImageDto.ImageDtoBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @SuppressWarnings("all")
        
        public ImageDto build() {
            return new ImageDto(this.id, this.address);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ImageDto.ImageDtoBuilder(id=" + this.id + ", address=" + this.address + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ImageDto.ImageDtoBuilder builder() {
        return new ImageDto.ImageDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getAddress() {
        return this.address;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ImageDto)) return false;
        final ImageDto other = (ImageDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ImageDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ImageDto(id=" + this.getId() + ", address=" + this.getAddress() + ")";
    }

    @SuppressWarnings("all")
    
    public ImageDto(final Long id, final String address) {
        this.id = id;
        this.address = address;
    }
    //</editor-fold>
}
