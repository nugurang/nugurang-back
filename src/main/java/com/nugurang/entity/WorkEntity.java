package com.nugurang.entity;

import com.nugurang.dto.WorkDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "work", uniqueConstraints = {@UniqueConstraint(columnNames = {"project", "name"}), @UniqueConstraint(columnNames = {"project", "name", "order"})})
public class WorkEntity implements BaseEntity<WorkDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean opened;
    @Column(nullable = false)
    private Integer order;
    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private ProjectEntity project;

    public WorkDto toDto() {
        return WorkDto.builder().id(id).name(name).opened(opened).order(order).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class WorkEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Boolean opened;
        @SuppressWarnings("all")
        
        private Integer order;
        @SuppressWarnings("all")
        
        private ProjectEntity project;

        @SuppressWarnings("all")
        
        WorkEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public WorkEntity.WorkEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkEntity.WorkEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkEntity.WorkEntityBuilder opened(final Boolean opened) {
            this.opened = opened;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkEntity.WorkEntityBuilder order(final Integer order) {
            this.order = order;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkEntity.WorkEntityBuilder project(final ProjectEntity project) {
            this.project = project;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkEntity build() {
            return new WorkEntity(this.id, this.name, this.opened, this.order, this.project);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "WorkEntity.WorkEntityBuilder(id=" + this.id + ", name=" + this.name + ", opened=" + this.opened + ", order=" + this.order + ", project=" + this.project + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static WorkEntity.WorkEntityBuilder builder() {
        return new WorkEntity.WorkEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected WorkEntity() {
    }

    @SuppressWarnings("all")
    
    public WorkEntity(final Long id, final String name, final Boolean opened, final Integer order, final ProjectEntity project) {
        this.id = id;
        this.name = name;
        this.opened = opened;
        this.order = order;
        this.project = project;
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
    
    public Boolean getOpened() {
        return this.opened;
    }

    @SuppressWarnings("all")
    
    public Integer getOrder() {
        return this.order;
    }

    @SuppressWarnings("all")
    
    public ProjectEntity getProject() {
        return this.project;
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
    
    public void setOpened(final Boolean opened) {
        this.opened = opened;
    }

    @SuppressWarnings("all")
    
    public void setOrder(final Integer order) {
        this.order = order;
    }

    @SuppressWarnings("all")
    
    public void setProject(final ProjectEntity project) {
        this.project = project;
    }
    //</editor-fold>
}
