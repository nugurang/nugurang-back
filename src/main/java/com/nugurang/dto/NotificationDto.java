package com.nugurang.dto;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;

public class NotificationDto {
    @NotNull
    private Long id;
    @NotNull
    private Boolean isRead;
    @NotNull
    private OffsetDateTime createdAt;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class NotificationDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private Boolean isRead;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;

        @SuppressWarnings("all")
        
        NotificationDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public NotificationDto.NotificationDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationDto.NotificationDtoBuilder isRead(final Boolean isRead) {
            this.isRead = isRead;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationDto.NotificationDtoBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotificationDto build() {
            return new NotificationDto(this.id, this.isRead, this.createdAt);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "NotificationDto.NotificationDtoBuilder(id=" + this.id + ", isRead=" + this.isRead + ", createdAt=" + this.createdAt + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static NotificationDto.NotificationDtoBuilder builder() {
        return new NotificationDto.NotificationDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public Boolean getIsRead() {
        return this.isRead;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setIsRead(final Boolean isRead) {
        this.isRead = isRead;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof NotificationDto)) return false;
        final NotificationDto other = (NotificationDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$isRead = this.getIsRead();
        final Object other$isRead = other.getIsRead();
        if (this$isRead == null ? other$isRead != null : !this$isRead.equals(other$isRead)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof NotificationDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $isRead = this.getIsRead();
        result = result * PRIME + ($isRead == null ? 43 : $isRead.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "NotificationDto(id=" + this.getId() + ", isRead=" + this.getIsRead() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    @SuppressWarnings("all")
    
    public NotificationDto(final Long id, final Boolean isRead, final OffsetDateTime createdAt) {
        this.id = id;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }
    //</editor-fold>
}
