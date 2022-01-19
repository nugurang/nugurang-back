package com.nugurang.entity;

import com.nugurang.dto.VoteTypeDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vote_type")
public class VoteTypeEntity implements BaseEntity<VoteTypeDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public VoteTypeDto toDto() {
        return VoteTypeDto.builder().id(id).name(name).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class VoteTypeEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;

        @SuppressWarnings("all")
        
        VoteTypeEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public VoteTypeEntity.VoteTypeEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteTypeEntity.VoteTypeEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteTypeEntity build() {
            return new VoteTypeEntity(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "VoteTypeEntity.VoteTypeEntityBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static VoteTypeEntity.VoteTypeEntityBuilder builder() {
        return new VoteTypeEntity.VoteTypeEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public VoteTypeEntity(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    
    protected VoteTypeEntity() {
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
