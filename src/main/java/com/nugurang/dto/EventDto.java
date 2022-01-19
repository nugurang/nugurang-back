package com.nugurang.dto;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;

public class EventDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private OffsetDateTime recruitingStart;
    @NotNull
    private OffsetDateTime recruitingEnd;
    @NotNull
    private OffsetDateTime eventStart;
    @NotNull
    private OffsetDateTime eventEnd;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class EventDtoBuilder {
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
        
        EventDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder recruitingStart(final OffsetDateTime recruitingStart) {
            this.recruitingStart = recruitingStart;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder recruitingEnd(final OffsetDateTime recruitingEnd) {
            this.recruitingEnd = recruitingEnd;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder eventStart(final OffsetDateTime eventStart) {
            this.eventStart = eventStart;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto.EventDtoBuilder eventEnd(final OffsetDateTime eventEnd) {
            this.eventEnd = eventEnd;
            return this;
        }

        @SuppressWarnings("all")
        
        public EventDto build() {
            return new EventDto(this.id, this.name, this.description, this.recruitingStart, this.recruitingEnd, this.eventStart, this.eventEnd);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "EventDto.EventDtoBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", recruitingStart=" + this.recruitingStart + ", recruitingEnd=" + this.recruitingEnd + ", eventStart=" + this.eventStart + ", eventEnd=" + this.eventEnd + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static EventDto.EventDtoBuilder builder() {
        return new EventDto.EventDtoBuilder();
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

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EventDto)) return false;
        final EventDto other = (EventDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) return false;
        final Object this$recruitingStart = this.getRecruitingStart();
        final Object other$recruitingStart = other.getRecruitingStart();
        if (this$recruitingStart == null ? other$recruitingStart != null : !this$recruitingStart.equals(other$recruitingStart)) return false;
        final Object this$recruitingEnd = this.getRecruitingEnd();
        final Object other$recruitingEnd = other.getRecruitingEnd();
        if (this$recruitingEnd == null ? other$recruitingEnd != null : !this$recruitingEnd.equals(other$recruitingEnd)) return false;
        final Object this$eventStart = this.getEventStart();
        final Object other$eventStart = other.getEventStart();
        if (this$eventStart == null ? other$eventStart != null : !this$eventStart.equals(other$eventStart)) return false;
        final Object this$eventEnd = this.getEventEnd();
        final Object other$eventEnd = other.getEventEnd();
        if (this$eventEnd == null ? other$eventEnd != null : !this$eventEnd.equals(other$eventEnd)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof EventDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $recruitingStart = this.getRecruitingStart();
        result = result * PRIME + ($recruitingStart == null ? 43 : $recruitingStart.hashCode());
        final Object $recruitingEnd = this.getRecruitingEnd();
        result = result * PRIME + ($recruitingEnd == null ? 43 : $recruitingEnd.hashCode());
        final Object $eventStart = this.getEventStart();
        result = result * PRIME + ($eventStart == null ? 43 : $eventStart.hashCode());
        final Object $eventEnd = this.getEventEnd();
        result = result * PRIME + ($eventEnd == null ? 43 : $eventEnd.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "EventDto(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", recruitingStart=" + this.getRecruitingStart() + ", recruitingEnd=" + this.getRecruitingEnd() + ", eventStart=" + this.getEventStart() + ", eventEnd=" + this.getEventEnd() + ")";
    }

    @SuppressWarnings("all")
    
    public EventDto(final Long id, final String name, final String description, final OffsetDateTime recruitingStart, final OffsetDateTime recruitingEnd, final OffsetDateTime eventStart, final OffsetDateTime eventEnd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.recruitingStart = recruitingStart;
        this.recruitingEnd = recruitingEnd;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }
    //</editor-fold>
}
