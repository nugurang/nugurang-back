package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class BoardInputDto {
    @NotNull
    private String name;
    private boolean placeholder;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class BoardInputDtoBuilder {
        @SuppressWarnings("all")
        private String name;
        @SuppressWarnings("all")
        private boolean placeholder;

        @SuppressWarnings("all")
        BoardInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        public BoardInputDto.BoardInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        public BoardInputDto.BoardInputDtoBuilder placeholder(final boolean placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        @SuppressWarnings("all")
        public BoardInputDto build() {
            return new BoardInputDto(this.name, this.placeholder);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "BoardInputDto.BoardInputDtoBuilder(name=" + this.name + ", placeholder=" + this.placeholder + ")";
        }
    }

    @SuppressWarnings("all")
    public static BoardInputDto.BoardInputDtoBuilder builder() {
        return new BoardInputDto.BoardInputDtoBuilder();
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
        if (!(o instanceof BoardInputDto)) return false;
        final BoardInputDto other = (BoardInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.isPlaceholder() != other.isPlaceholder()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof BoardInputDto;
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
        return "BoardInputDto(name=" + this.getName() + ", placeholder=" + this.isPlaceholder() + ")";
    }

    @SuppressWarnings("all")
    public BoardInputDto(final String name, final boolean placeholder) {
        this.name = name;
        this.placeholder = placeholder;
    }
    //</editor-fold>
}
