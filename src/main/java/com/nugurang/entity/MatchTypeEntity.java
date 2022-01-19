package com.nugurang.entity;

import com.nugurang.dto.MatchTypeDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "match_type")
public class MatchTypeEntity implements BaseEntity<MatchTypeDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public MatchTypeDto toDto() {
        return MatchTypeDto.builder().id(id).name(name).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class MatchTypeEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;

        @SuppressWarnings("all")
        
        MatchTypeEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public MatchTypeEntity.MatchTypeEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchTypeEntity.MatchTypeEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchTypeEntity build() {
            return new MatchTypeEntity(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "MatchTypeEntity.MatchTypeEntityBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static MatchTypeEntity.MatchTypeEntityBuilder builder() {
        return new MatchTypeEntity.MatchTypeEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public MatchTypeEntity(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    
    protected MatchTypeEntity() {
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
