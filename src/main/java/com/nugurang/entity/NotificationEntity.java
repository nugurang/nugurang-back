package com.nugurang.entity;

import com.nugurang.dto.NotificationDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "notification")
public class NotificationEntity implements BaseEntity<NotificationDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Boolean isRead;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "notification_type", nullable = false)
    private NotificationTypeEntity notificationType;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    public NotificationDto toDto() {
        return NotificationDto.builder().id(id).isRead(isRead).createdAt(createdAt).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class NotificationEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        
        private Boolean isRead;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private NotificationTypeEntity notificationType;
        @SuppressWarnings("all")
        
        private UserEntity user;

        @SuppressWarnings("all")
        
        NotificationEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public NotificationEntity.NotificationEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationEntity.NotificationEntityBuilder isRead(final Boolean isRead) {
            this.isRead = isRead;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationEntity.NotificationEntityBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationEntity.NotificationEntityBuilder notificationType(final NotificationTypeEntity notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationEntity.NotificationEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationEntity build() {
            return new NotificationEntity(this.id, this.isRead, this.createdAt, this.notificationType, this.user);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "NotificationEntity.NotificationEntityBuilder(id=" + this.id + ", isRead=" + this.isRead + ", createdAt=" + this.createdAt + ", notificationType=" + this.notificationType + ", user=" + this.user + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static NotificationEntity.NotificationEntityBuilder builder() {
        return new NotificationEntity.NotificationEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public NotificationEntity(final Long id, final Boolean isRead, final OffsetDateTime createdAt, final NotificationTypeEntity notificationType, final UserEntity user) {
        this.id = id;
        this.isRead = isRead;
        this.createdAt = createdAt;
        this.notificationType = notificationType;
        this.user = user;
    }

    @SuppressWarnings("all")
    
    protected NotificationEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public Boolean getIsRead() {
        return this.isRead;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public NotificationTypeEntity getNotificationType() {
        return this.notificationType;
    }

    @SuppressWarnings("all")
    
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setIsRead(final Boolean isRead) {
        this.isRead = isRead;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setNotificationType(final NotificationTypeEntity notificationType) {
        this.notificationType = notificationType;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }
    //</editor-fold>
}
