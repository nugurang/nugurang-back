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
@Table(name = "acl_entry", uniqueConstraints = {@UniqueConstraint(columnNames = {"acl_object_identity", "ace_order"})})
public class AclEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "acl_object_identity", nullable = false)
    private AclObjectIdentityEntity aclObjectIdentity;
    @Column(name = "ace_order", nullable = false)
    private Integer aceOrder;
    @ManyToOne
    @JoinColumn(name = "sid", nullable = false)
    private AclSidEntity sid;
    @Column(nullable = false)
    private Integer mask;
    @Column(nullable = false)
    private Boolean granting;
    @Column(nullable = false)
    private Boolean auditSuccess;
    @Column(nullable = false)
    private Boolean auditFailure;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class AclEntryEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private AclObjectIdentityEntity aclObjectIdentity;
        @SuppressWarnings("all")
        
        private Integer aceOrder;
        @SuppressWarnings("all")
        
        private AclSidEntity sid;
        @SuppressWarnings("all")
        
        private Integer mask;
        @SuppressWarnings("all")
        
        private Boolean granting;
        @SuppressWarnings("all")
        
        private Boolean auditSuccess;
        @SuppressWarnings("all")
        
        private Boolean auditFailure;

        @SuppressWarnings("all")
        
        AclEntryEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder aclObjectIdentity(final AclObjectIdentityEntity aclObjectIdentity) {
            this.aclObjectIdentity = aclObjectIdentity;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder aceOrder(final Integer aceOrder) {
            this.aceOrder = aceOrder;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder sid(final AclSidEntity sid) {
            this.sid = sid;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder mask(final Integer mask) {
            this.mask = mask;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder granting(final Boolean granting) {
            this.granting = granting;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder auditSuccess(final Boolean auditSuccess) {
            this.auditSuccess = auditSuccess;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity.AclEntryEntityBuilder auditFailure(final Boolean auditFailure) {
            this.auditFailure = auditFailure;
            return this;
        }

        @SuppressWarnings("all")
        
        public AclEntryEntity build() {
            return new AclEntryEntity(this.id, this.aclObjectIdentity, this.aceOrder, this.sid, this.mask, this.granting, this.auditSuccess, this.auditFailure);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "AclEntryEntity.AclEntryEntityBuilder(id=" + this.id + ", aclObjectIdentity=" + this.aclObjectIdentity + ", aceOrder=" + this.aceOrder + ", sid=" + this.sid + ", mask=" + this.mask + ", granting=" + this.granting + ", auditSuccess=" + this.auditSuccess + ", auditFailure=" + this.auditFailure + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static AclEntryEntity.AclEntryEntityBuilder builder() {
        return new AclEntryEntity.AclEntryEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected AclEntryEntity() {
    }

    @SuppressWarnings("all")
    
    public AclEntryEntity(final Long id, final AclObjectIdentityEntity aclObjectIdentity, final Integer aceOrder, final AclSidEntity sid, final Integer mask, final Boolean granting, final Boolean auditSuccess, final Boolean auditFailure) {
        this.id = id;
        this.aclObjectIdentity = aclObjectIdentity;
        this.aceOrder = aceOrder;
        this.sid = sid;
        this.mask = mask;
        this.granting = granting;
        this.auditSuccess = auditSuccess;
        this.auditFailure = auditFailure;
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public AclObjectIdentityEntity getAclObjectIdentity() {
        return this.aclObjectIdentity;
    }

    @SuppressWarnings("all")
    
    public Integer getAceOrder() {
        return this.aceOrder;
    }

    @SuppressWarnings("all")
    
    public AclSidEntity getSid() {
        return this.sid;
    }

    @SuppressWarnings("all")
    
    public Integer getMask() {
        return this.mask;
    }

    @SuppressWarnings("all")
    
    public Boolean getGranting() {
        return this.granting;
    }

    @SuppressWarnings("all")
    
    public Boolean getAuditSuccess() {
        return this.auditSuccess;
    }

    @SuppressWarnings("all")
    
    public Boolean getAuditFailure() {
        return this.auditFailure;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setAclObjectIdentity(final AclObjectIdentityEntity aclObjectIdentity) {
        this.aclObjectIdentity = aclObjectIdentity;
    }

    @SuppressWarnings("all")
    
    public void setAceOrder(final Integer aceOrder) {
        this.aceOrder = aceOrder;
    }

    @SuppressWarnings("all")
    
    public void setSid(final AclSidEntity sid) {
        this.sid = sid;
    }

    @SuppressWarnings("all")
    
    public void setMask(final Integer mask) {
        this.mask = mask;
    }

    @SuppressWarnings("all")
    
    public void setGranting(final Boolean granting) {
        this.granting = granting;
    }

    @SuppressWarnings("all")
    
    public void setAuditSuccess(final Boolean auditSuccess) {
        this.auditSuccess = auditSuccess;
    }

    @SuppressWarnings("all")
    
    public void setAuditFailure(final Boolean auditFailure) {
        this.auditFailure = auditFailure;
    }
    //</editor-fold>
}
