package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class TagEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String name;

        @SuppressWarnings("all")
        TagEntityBuilder() {
        }

        @SuppressWarnings("all")
        public TagEntity.TagEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public TagEntity.TagEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        public TagEntity build() {
            return new TagEntity(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "TagEntity.TagEntityBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    public static TagEntity.TagEntityBuilder builder() {
        return new TagEntity.TagEntityBuilder();
    }

    @SuppressWarnings("all")
    public TagEntity(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    protected TagEntity() {
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
