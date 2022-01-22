package com.nugurang.entity;

import com.nugurang.dto.PositionDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class PositionEntity implements BaseEntity<PositionDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = true)
    private String description;
    @ManyToOne
    @JoinColumn(name = "image", nullable = true)
    private ImageEntity image;

    public PositionDto toDto() {
        return new PositionDto(id, name, description);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class PositionEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String description;
        @SuppressWarnings("all")
        
        private ImageEntity image;

        @SuppressWarnings("all")
        
        PositionEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public PositionEntity.PositionEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionEntity.PositionEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionEntity.PositionEntityBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionEntity.PositionEntityBuilder image(final ImageEntity image) {
            this.image = image;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionEntity build() {
            return new PositionEntity(this.id, this.name, this.description, this.image);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "PositionEntity.PositionEntityBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", image=" + this.image + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static PositionEntity.PositionEntityBuilder builder() {
        return new PositionEntity.PositionEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public PositionEntity(final Long id, final String name, final String description, final ImageEntity image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    @SuppressWarnings("all")
    
    protected PositionEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public String getDescription() {
        return this.description;
    }

    @SuppressWarnings("all")
    
    public ImageEntity getImage() {
        return this.image;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setDescription(final String description) {
        this.description = description;
    }

    @SuppressWarnings("all")
    
    public void setImage(final ImageEntity image) {
        this.image = image;
    }
    //</editor-fold>
}
