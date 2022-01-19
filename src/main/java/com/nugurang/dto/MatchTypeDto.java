package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class MatchTypeDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MatchTypeDtoBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String name;

        @SuppressWarnings("all")
        MatchTypeDtoBuilder() {
        }

        @SuppressWarnings("all")
        public MatchTypeDto.MatchTypeDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public MatchTypeDto.MatchTypeDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        public MatchTypeDto build() {
            return new MatchTypeDto(this.id, this.name);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MatchTypeDto.MatchTypeDtoBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    public static MatchTypeDto.MatchTypeDtoBuilder builder() {
        return new MatchTypeDto.MatchTypeDtoBuilder();
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
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MatchTypeDto)) return false;
        final MatchTypeDto other = (MatchTypeDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MatchTypeDto;
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
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MatchTypeDto(id=" + this.getId() + ", name=" + this.getName() + ")";
    }

    @SuppressWarnings("all")
    public MatchTypeDto(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }
    //</editor-fold>
}
