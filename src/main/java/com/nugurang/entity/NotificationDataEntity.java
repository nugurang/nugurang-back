package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification_data")
public class NotificationDataEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String value;
    @ManyToOne
    @JoinColumn(name = "notification", nullable = false)
    private NotificationEntity notification;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class NotificationDataEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String value;
        @SuppressWarnings("all")
        
        private NotificationEntity notification;

        @SuppressWarnings("all")
        
        NotificationDataEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public NotificationDataEntity.NotificationDataEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationDataEntity.NotificationDataEntityBuilder value(final String value) {
            this.value = value;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationDataEntity.NotificationDataEntityBuilder notification(final NotificationEntity notification) {
            this.notification = notification;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationDataEntity build() {
            return new NotificationDataEntity(this.id, this.value, this.notification);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "NotificationDataEntity.NotificationDataEntityBuilder(id=" + this.id + ", value=" + this.value + ", notification=" + this.notification + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static NotificationDataEntity.NotificationDataEntityBuilder builder() {
        return new NotificationDataEntity.NotificationDataEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public NotificationDataEntity(final Long id, final String value, final NotificationEntity notification) {
        this.id = id;
        this.value = value;
        this.notification = notification;
    }

    @SuppressWarnings("all")
    
    protected NotificationDataEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getValue() {
        return this.value;
    }

    @SuppressWarnings("all")
    
    public NotificationEntity getNotification() {
        return this.notification;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setValue(final String value) {
        this.value = value;
    }

    @SuppressWarnings("all")
    
    public void setNotification(final NotificationEntity notification) {
        this.notification = notification;
    }
    //</editor-fold>
}
