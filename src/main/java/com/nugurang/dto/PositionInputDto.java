package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;

public class PositionInputDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Optional<String> description;
    @NotNull
    private Optional<Long> image;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class PositionInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Optional<String> description;
        @SuppressWarnings("all")
        
        private Optional<Long> image;

        @SuppressWarnings("all")
        
        PositionInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public PositionInputDto.PositionInputDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionInputDto.PositionInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionInputDto.PositionInputDtoBuilder description(final Optional<String> description) {
            this.description = description;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionInputDto.PositionInputDtoBuilder image(final Optional<Long> image) {
            this.image = image;
            return this;
        }

        @SuppressWarnings("all")
        
        public PositionInputDto build() {
            return new PositionInputDto(this.id, this.name, this.description, this.image);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "PositionInputDto.PositionInputDtoBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", image=" + this.image + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static PositionInputDto.PositionInputDtoBuilder builder() {
        return new PositionInputDto.PositionInputDtoBuilder();
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
    
    public Optional<Long> getImage() {
        return this.image;
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

    @SuppressWarnings("all")
    
    public void setImage(final Optional<Long> image) {
        this.image = image;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PositionInputDto)) return false;
        final PositionInputDto other = (PositionInputDto) o;
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
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof PositionInputDto;
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
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "PositionInputDto(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", image=" + this.getImage() + ")";
    }

    @SuppressWarnings("all")
    
    public PositionInputDto(final Long id, final String name, final Optional<String> description, final Optional<Long> image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }
    //</editor-fold>
}
