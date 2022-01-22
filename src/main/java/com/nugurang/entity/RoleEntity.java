package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// TODO: Remove role and use spring security ACL
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class RoleEntityBuilder {
        @SuppressWarnings("all")
        
        private String name;

        @SuppressWarnings("all")
        
        RoleEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public RoleEntity.RoleEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public RoleEntity build() {
            return new RoleEntity(this.name);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "RoleEntity.RoleEntityBuilder(name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static RoleEntity.RoleEntityBuilder builder() {
        return new RoleEntity.RoleEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected RoleEntity() {
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
