package com.nugurang.entity;

import com.nugurang.dto.ImageDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class ImageEntity implements BaseEntity<ImageDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String address;

    public ImageDto toDto() {
        return ImageDto.builder().id(id).address(address).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ImageEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String address;

        @SuppressWarnings("all")
        
        ImageEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public ImageEntity.ImageEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ImageEntity.ImageEntityBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @SuppressWarnings("all")
        
        public ImageEntity build() {
            return new ImageEntity(this.id, this.address);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ImageEntity.ImageEntityBuilder(id=" + this.id + ", address=" + this.address + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ImageEntity.ImageEntityBuilder builder() {
        return new ImageEntity.ImageEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public ImageEntity(final Long id, final String address) {
        this.id = id;
        this.address = address;
    }

    @SuppressWarnings("all")
    
    protected ImageEntity() {
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
    //</editor-fold>
}
