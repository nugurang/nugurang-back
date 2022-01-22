package com.nugurang.entity;

import com.nugurang.dto.EventDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class EventEntity implements BaseEntity<EventDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private OffsetDateTime recruitingStart;
    @Column(nullable = false)
    private OffsetDateTime recruitingEnd;
    @Column(nullable = false)
    private OffsetDateTime eventStart;
    @Column(nullable = false)
    private OffsetDateTime eventEnd;

    public EventDto toDto() {
        return new EventDto(
            id,
            name,
            description,
            recruitingStart,
            recruitingEnd,
            eventStart,
            eventEnd
        );
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class EventEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String description;
        @SuppressWarnings("all")
        
        private OffsetDateTime recruitingStart;
        @SuppressWarnings("all")
        
        private OffsetDateTime recruitingEnd;
        @SuppressWarnings("all")
        
        private OffsetDateTime eventStart;
        @SuppressWarnings("all")
        
        private OffsetDateTime eventEnd;

        @SuppressWarnings("all")
        
        EventEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder recruitingStart(final OffsetDateTime recruitingStart) {
            this.recruitingStart = recruitingStart;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder recruitingEnd(final OffsetDateTime recruitingEnd) {
            this.recruitingEnd = recruitingEnd;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder eventStart(final OffsetDateTime eventStart) {
            this.eventStart = eventStart;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity.EventEntityBuilder eventEnd(final OffsetDateTime eventEnd) {
            this.eventEnd = eventEnd;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventEntity build() {
            return new EventEntity(this.id, this.name, this.description, this.recruitingStart, this.recruitingEnd, this.eventStart, this.eventEnd);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "EventEntity.EventEntityBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", recruitingStart=" + this.recruitingStart + ", recruitingEnd=" + this.recruitingEnd + ", eventStart=" + this.eventStart + ", eventEnd=" + this.eventEnd + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static EventEntity.EventEntityBuilder builder() {
        return new EventEntity.EventEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public EventEntity(final Long id, final String name, final String description, final OffsetDateTime recruitingStart, final OffsetDateTime recruitingEnd, final OffsetDateTime eventStart, final OffsetDateTime eventEnd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.recruitingStart = recruitingStart;
        this.recruitingEnd = recruitingEnd;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }

    @SuppressWarnings("all")
    
    protected EventEntity() {
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
    
    public String getDescription() {
        return this.description;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getRecruitingStart() {
        return this.recruitingStart;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getRecruitingEnd() {
        return this.recruitingEnd;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getEventStart() {
        return this.eventStart;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getEventEnd() {
        return this.eventEnd;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setDescription(final String description) {
        this.description = description;
    }

    @SuppressWarnings("all")
    
    public void setRecruitingStart(final OffsetDateTime recruitingStart) {
        this.recruitingStart = recruitingStart;
    }

    @SuppressWarnings("all")
    
    public void setRecruitingEnd(final OffsetDateTime recruitingEnd) {
        this.recruitingEnd = recruitingEnd;
    }

    @SuppressWarnings("all")
    
    public void setEventStart(final OffsetDateTime eventStart) {
        this.eventStart = eventStart;
    }

    @SuppressWarnings("all")
    
    public void setEventEnd(final OffsetDateTime eventEnd) {
        this.eventEnd = eventEnd;
    }
    //</editor-fold>
}
