package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class TagInputDto {
    @NotNull
    private String name;
    private boolean placeholder;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TagInputDtoBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private boolean placeholder;

        @SuppressWarnings("all")
        
        TagInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public TagInputDto.TagInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public TagInputDto.TagInputDtoBuilder placeholder(final boolean placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        @SuppressWarnings("all")
        
        public TagInputDto build() {
            return new TagInputDto(this.name, this.placeholder);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TagInputDto.TagInputDtoBuilder(name=" + this.name + ", placeholder=" + this.placeholder + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TagInputDto.TagInputDtoBuilder builder() {
        return new TagInputDto.TagInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public boolean isPlaceholder() {
        return this.placeholder;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setPlaceholder(final boolean placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TagInputDto)) return false;
        final TagInputDto other = (TagInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.isPlaceholder() != other.isPlaceholder()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof TagInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isPlaceholder() ? 79 : 97);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "TagInputDto(name=" + this.getName() + ", placeholder=" + this.isPlaceholder() + ")";
    }

    @SuppressWarnings("all")
    
    public TagInputDto(final String name, final boolean placeholder) {
        this.name = name;
        this.placeholder = placeholder;
    }
    //</editor-fold>
}
