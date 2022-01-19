package com.nugurang.dto;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;

public class ThreadDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime modifiedAt;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ThreadDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private OffsetDateTime modifiedAt;

        @SuppressWarnings("all")
        
        ThreadDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ThreadDto.ThreadDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadDto.ThreadDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadDto.ThreadDtoBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadDto.ThreadDtoBuilder modifiedAt(final OffsetDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadDto build() {
            return new ThreadDto(this.id, this.name, this.createdAt, this.modifiedAt);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ThreadDto.ThreadDtoBuilder(id=" + this.id + ", name=" + this.name + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ThreadDto.ThreadDtoBuilder builder() {
        return new ThreadDto.ThreadDtoBuilder();
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
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
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
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setModifiedAt(final OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ThreadDto)) return false;
        final ThreadDto other = (ThreadDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$modifiedAt = this.getModifiedAt();
        final Object other$modifiedAt = other.getModifiedAt();
        if (this$modifiedAt == null ? other$modifiedAt != null : !this$modifiedAt.equals(other$modifiedAt)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ThreadDto;
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
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $modifiedAt = this.getModifiedAt();
        result = result * PRIME + ($modifiedAt == null ? 43 : $modifiedAt.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ThreadDto(id=" + this.getId() + ", name=" + this.getName() + ", createdAt=" + this.getCreatedAt() + ", modifiedAt=" + this.getModifiedAt() + ")";
    }

    @SuppressWarnings("all")
    
    public ThreadDto(final Long id, final String name, final OffsetDateTime createdAt, final OffsetDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    //</editor-fold>
}
