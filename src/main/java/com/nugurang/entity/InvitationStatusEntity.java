package com.nugurang.entity;

import com.nugurang.dto.InvitationStatusDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invitation_status")
public class InvitationStatusEntity implements BaseEntity<InvitationStatusDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public InvitationStatusDto toDto() {
        return new InvitationStatusDto(id, name);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class InvitationStatusEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;

        @SuppressWarnings("all")
        
        InvitationStatusEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public InvitationStatusEntity.InvitationStatusEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public InvitationStatusEntity.InvitationStatusEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public InvitationStatusEntity build() {
            return new InvitationStatusEntity(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "InvitationStatusEntity.InvitationStatusEntityBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static InvitationStatusEntity.InvitationStatusEntityBuilder builder() {
        return new InvitationStatusEntity.InvitationStatusEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public InvitationStatusEntity(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    
    protected InvitationStatusEntity() {
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
