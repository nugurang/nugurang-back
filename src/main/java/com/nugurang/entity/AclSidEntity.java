package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "acl_sid", uniqueConstraints = {@UniqueConstraint(columnNames = {"sid", "principal"})})
public class AclSidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Boolean principal;
    @Column(nullable = false)
    private String sid;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class AclSidEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private Boolean principal;
        @SuppressWarnings("all")
        private String sid;

        @SuppressWarnings("all")
        AclSidEntityBuilder() {
        }

        @SuppressWarnings("all")
        public AclSidEntity.AclSidEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public AclSidEntity.AclSidEntityBuilder principal(final Boolean principal) {
            this.principal = principal;
            return this;
        }

        @SuppressWarnings("all")
        public AclSidEntity.AclSidEntityBuilder sid(final String sid) {
            this.sid = sid;
            return this;
        }

        @SuppressWarnings("all")
        public AclSidEntity build() {
            return new AclSidEntity(this.id, this.principal, this.sid);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "AclSidEntity.AclSidEntityBuilder(id=" + this.id + ", principal=" + this.principal + ", sid=" + this.sid + ")";
        }
    }

    @SuppressWarnings("all")
    public static AclSidEntity.AclSidEntityBuilder builder() {
        return new AclSidEntity.AclSidEntityBuilder();
    }

    @SuppressWarnings("all")
    protected AclSidEntity() {
    }

    @SuppressWarnings("all")
    public AclSidEntity(final Long id, final Boolean principal, final String sid) {
        this.id = id;
        this.principal = principal;
        this.sid = sid;
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public Boolean getPrincipal() {
        return this.principal;
    }

    @SuppressWarnings("all")
    public String getSid() {
        return this.sid;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setPrincipal(final Boolean principal) {
        this.principal = principal;
    }

    @SuppressWarnings("all")
    public void setSid(final String sid) {
        this.sid = sid;
    }
    //</editor-fold>
}
