package com.nugurang.dto;

import java.time.OffsetDateTime;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public class MatchRequestInputDto {
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private Optional<Integer> days;
    @NotNull
    private Optional<Integer> hours;
    @NotNull
    private Optional<Integer> minutes;
    @NotNull
    private Integer minTeamSize;
    @NotNull
    private Optional<Integer> maxTeamSize;
    @NotNull
    private Long type;
    @NotNull
    private Long event;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MatchRequestInputDtoBuilder {
        @SuppressWarnings("all")
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        private Optional<Integer> days;
        @SuppressWarnings("all")
        private Optional<Integer> hours;
        @SuppressWarnings("all")
        private Optional<Integer> minutes;
        @SuppressWarnings("all")
        private Integer minTeamSize;
        @SuppressWarnings("all")
        private Optional<Integer> maxTeamSize;
        @SuppressWarnings("all")
        private Long type;
        @SuppressWarnings("all")
        private Long event;

        @SuppressWarnings("all")
        MatchRequestInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder days(final Optional<Integer> days) {
            this.days = days;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder hours(final Optional<Integer> hours) {
            this.hours = hours;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder minutes(final Optional<Integer> minutes) {
            this.minutes = minutes;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder minTeamSize(final Integer minTeamSize) {
            this.minTeamSize = minTeamSize;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder maxTeamSize(final Optional<Integer> maxTeamSize) {
            this.maxTeamSize = maxTeamSize;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder type(final Long type) {
            this.type = type;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto.MatchRequestInputDtoBuilder event(final Long event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        public MatchRequestInputDto build() {
            return new MatchRequestInputDto(this.createdAt, this.days, this.hours, this.minutes, this.minTeamSize, this.maxTeamSize, this.type, this.event);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MatchRequestInputDto.MatchRequestInputDtoBuilder(createdAt=" + this.createdAt + ", days=" + this.days + ", hours=" + this.hours + ", minutes=" + this.minutes + ", minTeamSize=" + this.minTeamSize + ", maxTeamSize=" + this.maxTeamSize + ", type=" + this.type + ", event=" + this.event + ")";
        }
    }

    @SuppressWarnings("all")
    public static MatchRequestInputDto.MatchRequestInputDtoBuilder builder() {
        return new MatchRequestInputDto.MatchRequestInputDtoBuilder();
    }

    @SuppressWarnings("all")
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    public Optional<Integer> getDays() {
        return this.days;
    }

    @SuppressWarnings("all")
    public Optional<Integer> getHours() {
        return this.hours;
    }

    @SuppressWarnings("all")
    public Optional<Integer> getMinutes() {
        return this.minutes;
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
    public Long getType() {
        return this.type;
    }

    @SuppressWarnings("all")
    public Long getEvent() {
        return this.event;
    }

    @SuppressWarnings("all")
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    public void setDays(final Optional<Integer> days) {
        this.days = days;
    }

    @SuppressWarnings("all")
    public void setHours(final Optional<Integer> hours) {
        this.hours = hours;
    }

    @SuppressWarnings("all")
    public void setMinutes(final Optional<Integer> minutes) {
        this.minutes = minutes;
    }

    @SuppressWarnings("all")
    public void setMinTeamSize(final Integer minTeamSize) {
        this.minTeamSize = minTeamSize;
    }

    @SuppressWarnings("all")
    public void setMaxTeamSize(final Optional<Integer> maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    @SuppressWarnings("all")
    public void setType(final Long type) {
        this.type = type;
    }

    @SuppressWarnings("all")
    public void setEvent(final Long event) {
        this.event = event;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MatchRequestInputDto)) return false;
        final MatchRequestInputDto other = (MatchRequestInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$minTeamSize = this.getMinTeamSize();
        final Object other$minTeamSize = other.getMinTeamSize();
        if (this$minTeamSize == null ? other$minTeamSize != null : !this$minTeamSize.equals(other$minTeamSize)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$event = this.getEvent();
        final Object other$event = other.getEvent();
        if (this$event == null ? other$event != null : !this$event.equals(other$event)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$days = this.getDays();
        final Object other$days = other.getDays();
        if (this$days == null ? other$days != null : !this$days.equals(other$days)) return false;
        final Object this$hours = this.getHours();
        final Object other$hours = other.getHours();
        if (this$hours == null ? other$hours != null : !this$hours.equals(other$hours)) return false;
        final Object this$minutes = this.getMinutes();
        final Object other$minutes = other.getMinutes();
        if (this$minutes == null ? other$minutes != null : !this$minutes.equals(other$minutes)) return false;
        final Object this$maxTeamSize = this.getMaxTeamSize();
        final Object other$maxTeamSize = other.getMaxTeamSize();
        if (this$maxTeamSize == null ? other$maxTeamSize != null : !this$maxTeamSize.equals(other$maxTeamSize)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MatchRequestInputDto;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $minTeamSize = this.getMinTeamSize();
        result = result * PRIME + ($minTeamSize == null ? 43 : $minTeamSize.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $event = this.getEvent();
        result = result * PRIME + ($event == null ? 43 : $event.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $days = this.getDays();
        result = result * PRIME + ($days == null ? 43 : $days.hashCode());
        final Object $hours = this.getHours();
        result = result * PRIME + ($hours == null ? 43 : $hours.hashCode());
        final Object $minutes = this.getMinutes();
        result = result * PRIME + ($minutes == null ? 43 : $minutes.hashCode());
        final Object $maxTeamSize = this.getMaxTeamSize();
        result = result * PRIME + ($maxTeamSize == null ? 43 : $maxTeamSize.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MatchRequestInputDto(createdAt=" + this.getCreatedAt() + ", days=" + this.getDays() + ", hours=" + this.getHours() + ", minutes=" + this.getMinutes() + ", minTeamSize=" + this.getMinTeamSize() + ", maxTeamSize=" + this.getMaxTeamSize() + ", type=" + this.getType() + ", event=" + this.getEvent() + ")";
    }

    @SuppressWarnings("all")
    public MatchRequestInputDto(final OffsetDateTime createdAt, final Optional<Integer> days, final Optional<Integer> hours, final Optional<Integer> minutes, final Integer minTeamSize, final Optional<Integer> maxTeamSize, final Long type, final Long event) {
        this.createdAt = createdAt;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.minTeamSize = minTeamSize;
        this.maxTeamSize = maxTeamSize;
        this.type = type;
        this.event = event;
    }
    //</editor-fold>
}
