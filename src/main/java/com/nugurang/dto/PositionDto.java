package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;

public class PositionDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Optional<String> description;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class PositionDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Optional<String> description;

        @SuppressWarnings("all")
        
        PositionDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public PositionDto.PositionDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionDto.PositionDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionDto.PositionDtoBuilder description(final Optional<String> description) {
            this.description = description;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionDto build() {
            return new PositionDto(this.id, this.name, this.description);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "PositionDto.PositionDtoBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static PositionDto.PositionDtoBuilder builder() {
        return new PositionDto.PositionDtoBuilder();
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
    
    public Optional<String> getDescription() {
        return this.description;
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
    
    public void setDescription(final Optional<String> description) {
        this.description = description;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PositionDto)) return false;
        final PositionDto other = (PositionDto) o;
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
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof PositionDto;
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
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "PositionDto(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ")";
    }

    @SuppressWarnings("all")
    
    public PositionDto(final Long id, final String name, final Optional<String> description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    //</editor-fold>
}
