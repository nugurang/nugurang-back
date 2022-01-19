package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;

public class ProjectInputDto {
    @NotNull
    private String name;
    @NotNull
    private Optional<Long> event;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ProjectInputDtoBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Optional<Long> event;

        @SuppressWarnings("all")
        
        ProjectInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ProjectInputDto.ProjectInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInputDto.ProjectInputDtoBuilder event(final Optional<Long> event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectInputDto build() {
            return new ProjectInputDto(this.name, this.event);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ProjectInputDto.ProjectInputDtoBuilder(name=" + this.name + ", event=" + this.event + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ProjectInputDto.ProjectInputDtoBuilder builder() {
        return new ProjectInputDto.ProjectInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public Optional<Long> getEvent() {
        return this.event;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setEvent(final Optional<Long> event) {
        this.event = event;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProjectInputDto)) return false;
        final ProjectInputDto other = (ProjectInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$event = this.getEvent();
        final Object other$event = other.getEvent();
        if (this$event == null ? other$event != null : !this$event.equals(other$event)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ProjectInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $event = this.getEvent();
        result = result * PRIME + ($event == null ? 43 : $event.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ProjectInputDto(name=" + this.getName() + ", event=" + this.getEvent() + ")";
    }

    @SuppressWarnings("all")
    
    public ProjectInputDto(final String name, final Optional<Long> event) {
        this.name = name;
        this.event = event;
    }
    //</editor-fold>
}
