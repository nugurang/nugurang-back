package com.nugurang.entity;

import com.nugurang.dto.NotificationTypeDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification_type")
public class NotificationTypeEntity implements BaseEntity<NotificationTypeDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public NotificationTypeDto toDto() {
        return new NotificationTypeDto(id, name);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class NotificationTypeEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;

        @SuppressWarnings("all")
        
        NotificationTypeEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public NotificationTypeEntity.NotificationTypeEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationTypeEntity.NotificationTypeEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationTypeEntity build() {
            return new NotificationTypeEntity(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "NotificationTypeEntity.NotificationTypeEntityBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static NotificationTypeEntity.NotificationTypeEntityBuilder builder() {
        return new NotificationTypeEntity.NotificationTypeEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public NotificationTypeEntity(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("all")
    
    protected NotificationTypeEntity() {
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
