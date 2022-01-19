package com.nugurang.entity;

import com.nugurang.dto.ProgressDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "progress")
public class ProgressEntity implements BaseEntity<ProgressDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    @Override
    public ProgressDto toDto() {
        return ProgressDto.builder().id(id).name(name).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ProgressEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;

        @SuppressWarnings("all")
        
        ProgressEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public ProgressEntity.ProgressEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProgressEntity.ProgressEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProgressEntity build() {
            return new ProgressEntity(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ProgressEntity.ProgressEntityBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ProgressEntity.ProgressEntityBuilder builder() {
        return new ProgressEntity.ProgressEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public ProgressEntity(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    
    protected ProgressEntity() {
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
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }
    //</editor-fold>
}
