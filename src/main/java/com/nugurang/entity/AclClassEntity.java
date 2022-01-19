package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acl_class")
public class AclClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class", nullable = false, unique = true)
    private String className;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class AclClassEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String className;

        @SuppressWarnings("all")
        AclClassEntityBuilder() {
        }

        @SuppressWarnings("all")
        public AclClassEntity.AclClassEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public AclClassEntity.AclClassEntityBuilder className(final String className) {
            this.className = className;
            return this;
        }

        @SuppressWarnings("all")
        public AclClassEntity build() {
            return new AclClassEntity(this.id, this.className);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "AclClassEntity.AclClassEntityBuilder(id=" + this.id + ", className=" + this.className + ")";
        }
    }

    @SuppressWarnings("all")
    public static AclClassEntity.AclClassEntityBuilder builder() {
        return new AclClassEntity.AclClassEntityBuilder();
    }

    @SuppressWarnings("all")
    protected AclClassEntity() {
    }

    @SuppressWarnings("all")
    public AclClassEntity(final Long id, final String className) {
        this.id = id;
        this.className = className;
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getClassName() {
        return this.className;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setClassName(final String className) {
        this.className = className;
    }
    //</editor-fold>
}
