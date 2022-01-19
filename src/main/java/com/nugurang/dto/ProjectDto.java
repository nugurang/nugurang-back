package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class ProjectDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Boolean finished;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ProjectDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Boolean finished;

        @SuppressWarnings("all")
        
        ProjectDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ProjectDto.ProjectDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectDto.ProjectDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectDto.ProjectDtoBuilder finished(final Boolean finished) {
            this.finished = finished;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectDto build() {
            return new ProjectDto(this.id, this.name, this.finished);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ProjectDto.ProjectDtoBuilder(id=" + this.id + ", name=" + this.name + ", finished=" + this.finished + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ProjectDto.ProjectDtoBuilder builder() {
        return new ProjectDto.ProjectDtoBuilder();
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
    
    public Boolean getFinished() {
        return this.finished;
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
    
    public void setFinished(final Boolean finished) {
        this.finished = finished;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProjectDto)) return false;
        final ProjectDto other = (ProjectDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$finished = this.getFinished();
        final Object other$finished = other.getFinished();
        if (this$finished == null ? other$finished != null : !this$finished.equals(other$finished)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ProjectDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $finished = this.getFinished();
        result = result * PRIME + ($finished == null ? 43 : $finished.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ProjectDto(id=" + this.getId() + ", name=" + this.getName() + ", finished=" + this.getFinished() + ")";
    }

    @SuppressWarnings("all")
    
    public ProjectDto(final Long id, final String name, final Boolean finished) {
        this.id = id;
        this.name = name;
        this.finished = finished;
    }
    //</editor-fold>
}
