package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "acl_object_identity", uniqueConstraints = {@UniqueConstraint(columnNames = {"object_id_class", "object_id_identity"})})
public class AclObjectIdentityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "object_id_class", nullable = false)
    private AclClassEntity objectIdClass;
    @Column(name = "object_id_identity", nullable = false)
    private Long objectIdIdentity;
    @ManyToOne
    @JoinColumn(name = "parent_object")
    private AclObjectIdentityEntity parentObject;
    @ManyToOne
    @JoinColumn(name = "owner_sid")
    private AclSidEntity ownerSid;
    @Column(nullable = false)
    private Boolean entriesInheriting;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class AclObjectIdentityEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private AclClassEntity objectIdClass;
        @SuppressWarnings("all")
        
        private Long objectIdIdentity;
        @SuppressWarnings("all")
        
        private AclObjectIdentityEntity parentObject;
        @SuppressWarnings("all")
        
        private AclSidEntity ownerSid;
        @SuppressWarnings("all")
        
        private Boolean entriesInheriting;

        @SuppressWarnings("all")
        
        AclObjectIdentityEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity.AclObjectIdentityEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity.AclObjectIdentityEntityBuilder objectIdClass(final AclClassEntity objectIdClass) {
            this.objectIdClass = objectIdClass;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity.AclObjectIdentityEntityBuilder objectIdIdentity(final Long objectIdIdentity) {
            this.objectIdIdentity = objectIdIdentity;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity.AclObjectIdentityEntityBuilder parentObject(final AclObjectIdentityEntity parentObject) {
            this.parentObject = parentObject;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity.AclObjectIdentityEntityBuilder ownerSid(final AclSidEntity ownerSid) {
            this.ownerSid = ownerSid;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity.AclObjectIdentityEntityBuilder entriesInheriting(final Boolean entriesInheriting) {
            this.entriesInheriting = entriesInheriting;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclObjectIdentityEntity build() {
            return new AclObjectIdentityEntity(this.id, this.objectIdClass, this.objectIdIdentity, this.parentObject, this.ownerSid, this.entriesInheriting);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "AclObjectIdentityEntity.AclObjectIdentityEntityBuilder(id=" + this.id + ", objectIdClass=" + this.objectIdClass + ", objectIdIdentity=" + this.objectIdIdentity + ", parentObject=" + this.parentObject + ", ownerSid=" + this.ownerSid + ", entriesInheriting=" + this.entriesInheriting + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static AclObjectIdentityEntity.AclObjectIdentityEntityBuilder builder() {
        return new AclObjectIdentityEntity.AclObjectIdentityEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected AclObjectIdentityEntity() {
    }

    @SuppressWarnings("all")
    
    public AclObjectIdentityEntity(final Long id, final AclClassEntity objectIdClass, final Long objectIdIdentity, final AclObjectIdentityEntity parentObject, final AclSidEntity ownerSid, final Boolean entriesInheriting) {
        this.id = id;
        this.objectIdClass = objectIdClass;
        this.objectIdIdentity = objectIdIdentity;
        this.parentObject = parentObject;
        this.ownerSid = ownerSid;
        this.entriesInheriting = entriesInheriting;
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public AclClassEntity getObjectIdClass() {
        return this.objectIdClass;
    }

    @SuppressWarnings("all")
    
    public Long getObjectIdIdentity() {
        return this.objectIdIdentity;
    }

    @SuppressWarnings("all")
    
    public AclObjectIdentityEntity getParentObject() {
        return this.parentObject;
    }

    @SuppressWarnings("all")
    
    public AclSidEntity getOwnerSid() {
        return this.ownerSid;
    }

    @SuppressWarnings("all")
    
    public Boolean getEntriesInheriting() {
        return this.entriesInheriting;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setObjectIdClass(final AclClassEntity objectIdClass) {
        this.objectIdClass = objectIdClass;
    }

    @SuppressWarnings("all")
    
    public void setObjectIdIdentity(final Long objectIdIdentity) {
        this.objectIdIdentity = objectIdIdentity;
    }

    @SuppressWarnings("all")
    
    public void setParentObject(final AclObjectIdentityEntity parentObject) {
        this.parentObject = parentObject;
    }

    @SuppressWarnings("all")
    
    public void setOwnerSid(final AclSidEntity ownerSid) {
        this.ownerSid = ownerSid;
    }

    @SuppressWarnings("all")
    
    public void setEntriesInheriting(final Boolean entriesInheriting) {
        this.entriesInheriting = entriesInheriting;
    }
    //</editor-fold>
}
