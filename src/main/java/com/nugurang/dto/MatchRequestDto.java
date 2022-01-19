package com.nugurang.dto;

import java.time.OffsetDateTime;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public class MatchRequestDto {
    @NotNull
    private Long id;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime expiredAt;
    @NotNull
    private Integer minTeamSize;
    @NotNull
    private Optional<Integer> maxTeamSize;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MatchRequestDtoBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        private OffsetDateTime expiredAt;
        @SuppressWarnings("all")
        private Integer minTeamSize;
        @SuppressWarnings("all")
        private Optional<Integer> maxTeamSize;

        @SuppressWarnings("all")
        MatchRequestDtoBuilder() {
        }

        @SuppressWarnings("all")
        public MatchRequestDto.MatchRequestDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestDto.MatchRequestDtoBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestDto.MatchRequestDtoBuilder expiredAt(final OffsetDateTime expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestDto.MatchRequestDtoBuilder minTeamSize(final Integer minTeamSize) {
            this.minTeamSize = minTeamSize;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestDto.MatchRequestDtoBuilder maxTeamSize(final Optional<Integer> maxTeamSize) {
            this.maxTeamSize = maxTeamSize;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestDto build() {
            return new MatchRequestDto(this.id, this.createdAt, this.expiredAt, this.minTeamSize, this.maxTeamSize);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MatchRequestDto.MatchRequestDtoBuilder(id=" + this.id + ", createdAt=" + this.createdAt + ", expiredAt=" + this.expiredAt + ", minTeamSize=" + this.minTeamSize + ", maxTeamSize=" + this.maxTeamSize + ")";
        }
    }

    @SuppressWarnings("all")
    public static MatchRequestDto.MatchRequestDtoBuilder builder() {
        return new MatchRequestDto.MatchRequestDtoBuilder();
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
    public Integer getMinTeamSize() {
        return this.minTeamSize;
    }

    @SuppressWarnings("all")
    public Optional<Integer> getMaxTeamSize() {
        return this.maxTeamSize;
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

    @SuppressWarnings("all")
    public void setMinTeamSize(final Integer minTeamSize) {
        this.minTeamSize = minTeamSize;
    }

    @SuppressWarnings("all")
    public void setMaxTeamSize(final Optional<Integer> maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MatchRequestDto)) return false;
        final MatchRequestDto other = (MatchRequestDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$minTeamSize = this.getMinTeamSize();
        final Object other$minTeamSize = other.getMinTeamSize();
        if (this$minTeamSize == null ? other$minTeamSize != null : !this$minTeamSize.equals(other$minTeamSize)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$expiredAt = this.getExpiredAt();
        final Object other$expiredAt = other.getExpiredAt();
        if (this$expiredAt == null ? other$expiredAt != null : !this$expiredAt.equals(other$expiredAt)) return false;
        final Object this$maxTeamSize = this.getMaxTeamSize();
        final Object other$maxTeamSize = other.getMaxTeamSize();
        if (this$maxTeamSize == null ? other$maxTeamSize != null : !this$maxTeamSize.equals(other$maxTeamSize)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MatchRequestDto;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $minTeamSize = this.getMinTeamSize();
        result = result * PRIME + ($minTeamSize == null ? 43 : $minTeamSize.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $expiredAt = this.getExpiredAt();
        result = result * PRIME + ($expiredAt == null ? 43 : $expiredAt.hashCode());
        final Object $maxTeamSize = this.getMaxTeamSize();
        result = result * PRIME + ($maxTeamSize == null ? 43 : $maxTeamSize.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MatchRequestDto(id=" + this.getId() + ", createdAt=" + this.getCreatedAt() + ", expiredAt=" + this.getExpiredAt() + ", minTeamSize=" + this.getMinTeamSize() + ", maxTeamSize=" + this.getMaxTeamSize() + ")";
    }

    @SuppressWarnings("all")
    public MatchRequestDto(final Long id, final OffsetDateTime createdAt, final OffsetDateTime expiredAt, final Integer minTeamSize, final Optional<Integer> maxTeamSize) {
        this.id = id;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.minTeamSize = minTeamSize;
        this.maxTeamSize = maxTeamSize;
    }
    //</editor-fold>
}
