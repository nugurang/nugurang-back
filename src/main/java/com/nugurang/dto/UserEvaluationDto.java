package com.nugurang.dto;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;

public class UserEvaluationDto {
    @NotNull
    private Long id;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime expiredAt;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserEvaluationDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private OffsetDateTime expiredAt;

        @SuppressWarnings("all")
        
        UserEvaluationDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserEvaluationDto.UserEvaluationDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationDto.UserEvaluationDtoBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationDto.UserEvaluationDtoBuilder expiredAt(final OffsetDateTime expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationDto build() {
            return new UserEvaluationDto(this.id, this.createdAt, this.expiredAt);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserEvaluationDto.UserEvaluationDtoBuilder(id=" + this.id + ", createdAt=" + this.createdAt + ", expiredAt=" + this.expiredAt + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserEvaluationDto.UserEvaluationDtoBuilder builder() {
        return new UserEvaluationDto.UserEvaluationDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getExpiredAt() {
        return this.expiredAt;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setExpiredAt(final OffsetDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserEvaluationDto)) return false;
        final UserEvaluationDto other = (UserEvaluationDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$expiredAt = this.getExpiredAt();
        final Object other$expiredAt = other.getExpiredAt();
        if (this$expiredAt == null ? other$expiredAt != null : !this$expiredAt.equals(other$expiredAt)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof UserEvaluationDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $expiredAt = this.getExpiredAt();
        result = result * PRIME + ($expiredAt == null ? 43 : $expiredAt.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "UserEvaluationDto(id=" + this.getId() + ", createdAt=" + this.getCreatedAt() + ", expiredAt=" + this.getExpiredAt() + ")";
    }

    @SuppressWarnings("all")
    
    public UserEvaluationDto(final Long id, final OffsetDateTime createdAt, final OffsetDateTime expiredAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }
    //</editor-fold>
}
