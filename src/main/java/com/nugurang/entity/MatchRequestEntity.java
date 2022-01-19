package com.nugurang.entity;

import com.nugurang.dto.MatchRequestDto;
import java.time.OffsetDateTime;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "match_request", uniqueConstraints = {@UniqueConstraint(columnNames = {"event", "user"})})
public class MatchRequestEntity implements BaseEntity<MatchRequestDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime expiredAt;
    @Column(nullable = false)
    private Integer minTeamSize;
    @Column(nullable = true)
    private Integer maxTeamSize;
    @ManyToOne
    @JoinColumn(name = "type")
    private MatchTypeEntity type;
    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;
    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Override
    public MatchRequestDto toDto() {
        return MatchRequestDto.builder().id(id).createdAt(createdAt).expiredAt(expiredAt).minTeamSize(minTeamSize).maxTeamSize(Optional.ofNullable(maxTeamSize)).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class MatchRequestEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private OffsetDateTime expiredAt;
        @SuppressWarnings("all")
        
        private Integer minTeamSize;
        @SuppressWarnings("all")
        
        private Integer maxTeamSize;
        @SuppressWarnings("all")
        
        private MatchTypeEntity type;
        @SuppressWarnings("all")
        
        private EventEntity event;
        @SuppressWarnings("all")
        
        private UserEntity user;

        @SuppressWarnings("all")
        
        MatchRequestEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder expiredAt(final OffsetDateTime expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder minTeamSize(final Integer minTeamSize) {
            this.minTeamSize = minTeamSize;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder maxTeamSize(final Integer maxTeamSize) {
            this.maxTeamSize = maxTeamSize;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder type(final MatchTypeEntity type) {
            this.type = type;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder event(final EventEntity event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity.MatchRequestEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public MatchRequestEntity build() {
            return new MatchRequestEntity(this.id, this.createdAt, this.expiredAt, this.minTeamSize, this.maxTeamSize, this.type, this.event, this.user);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "MatchRequestEntity.MatchRequestEntityBuilder(id=" + this.id + ", createdAt=" + this.createdAt + ", expiredAt=" + this.expiredAt + ", minTeamSize=" + this.minTeamSize + ", maxTeamSize=" + this.maxTeamSize + ", type=" + this.type + ", event=" + this.event + ", user=" + this.user + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static MatchRequestEntity.MatchRequestEntityBuilder builder() {
        return new MatchRequestEntity.MatchRequestEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public MatchRequestEntity(final Long id, final OffsetDateTime createdAt, final OffsetDateTime expiredAt, final Integer minTeamSize, final Integer maxTeamSize, final MatchTypeEntity type, final EventEntity event, final UserEntity user) {
        this.id = id;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.minTeamSize = minTeamSize;
        this.maxTeamSize = maxTeamSize;
        this.type = type;
        this.event = event;
        this.user = user;
    }

    @SuppressWarnings("all")
    
    protected MatchRequestEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getExpiredAt() {
        return this.expiredAt;
    }

    @SuppressWarnings("all")
    
    public Integer getMinTeamSize() {
        return this.minTeamSize;
    }

    @SuppressWarnings("all")
    
    public Integer getMaxTeamSize() {
        return this.maxTeamSize;
    }

    @SuppressWarnings("all")
    
    public MatchTypeEntity getType() {
        return this.type;
    }

    @SuppressWarnings("all")
    
    public EventEntity getEvent() {
        return this.event;
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
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setExpiredAt(final OffsetDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    @SuppressWarnings("all")
    
    public void setMinTeamSize(final Integer minTeamSize) {
        this.minTeamSize = minTeamSize;
    }

    @SuppressWarnings("all")
    
    public void setMaxTeamSize(final Integer maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    @SuppressWarnings("all")
    
    public void setType(final MatchTypeEntity type) {
        this.type = type;
    }

    @SuppressWarnings("all")
    
    public void setEvent(final EventEntity event) {
        this.event = event;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }
    //</editor-fold>
}
