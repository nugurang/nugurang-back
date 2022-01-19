package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;

public class ThreadInputDto {
    @NotNull
    private String name;
    @NotNull
    private ArticleInputDto firstArticle;
    @NotNull
    private Long board;
    @NotNull
    private Optional<Long> event;
    @NotNull
    private Optional<Long> team;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ThreadInputDtoBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private ArticleInputDto firstArticle;
        @SuppressWarnings("all")
        
        private Long board;
        @SuppressWarnings("all")
        
        private Optional<Long> event;
        @SuppressWarnings("all")
        
        private Optional<Long> team;

        @SuppressWarnings("all")
        
        ThreadInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ThreadInputDto.ThreadInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadInputDto.ThreadInputDtoBuilder firstArticle(final ArticleInputDto firstArticle) {
            this.firstArticle = firstArticle;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadInputDto.ThreadInputDtoBuilder board(final Long board) {
            this.board = board;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadInputDto.ThreadInputDtoBuilder event(final Optional<Long> event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadInputDto.ThreadInputDtoBuilder team(final Optional<Long> team) {
            this.team = team;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadInputDto build() {
            return new ThreadInputDto(this.name, this.firstArticle, this.board, this.event, this.team);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ThreadInputDto.ThreadInputDtoBuilder(name=" + this.name + ", firstArticle=" + this.firstArticle + ", board=" + this.board + ", event=" + this.event + ", team=" + this.team + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ThreadInputDto.ThreadInputDtoBuilder builder() {
        return new ThreadInputDto.ThreadInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public ArticleInputDto getFirstArticle() {
        return this.firstArticle;
    }

    @SuppressWarnings("all")
    
    public Long getBoard() {
        return this.board;
    }

    @SuppressWarnings("all")
    
    public Optional<Long> getEvent() {
        return this.event;
    }

    @SuppressWarnings("all")
    
    public Optional<Long> getTeam() {
        return this.team;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setFirstArticle(final ArticleInputDto firstArticle) {
        this.firstArticle = firstArticle;
    }

    @SuppressWarnings("all")
    
    public void setBoard(final Long board) {
        this.board = board;
    }

    @SuppressWarnings("all")
    
    public void setEvent(final Optional<Long> event) {
        this.event = event;
    }

    @SuppressWarnings("all")
    
    public void setTeam(final Optional<Long> team) {
        this.team = team;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ThreadInputDto)) return false;
        final ThreadInputDto other = (ThreadInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$board = this.getBoard();
        final Object other$board = other.getBoard();
        if (this$board == null ? other$board != null : !this$board.equals(other$board)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$firstArticle = this.getFirstArticle();
        final Object other$firstArticle = other.getFirstArticle();
        if (this$firstArticle == null ? other$firstArticle != null : !this$firstArticle.equals(other$firstArticle)) return false;
        final Object this$event = this.getEvent();
        final Object other$event = other.getEvent();
        if (this$event == null ? other$event != null : !this$event.equals(other$event)) return false;
        final Object this$team = this.getTeam();
        final Object other$team = other.getTeam();
        if (this$team == null ? other$team != null : !this$team.equals(other$team)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ThreadInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $board = this.getBoard();
        result = result * PRIME + ($board == null ? 43 : $board.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $firstArticle = this.getFirstArticle();
        result = result * PRIME + ($firstArticle == null ? 43 : $firstArticle.hashCode());
        final Object $event = this.getEvent();
        result = result * PRIME + ($event == null ? 43 : $event.hashCode());
        final Object $team = this.getTeam();
        result = result * PRIME + ($team == null ? 43 : $team.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ThreadInputDto(name=" + this.getName() + ", firstArticle=" + this.getFirstArticle() + ", board=" + this.getBoard() + ", event=" + this.getEvent() + ", team=" + this.getTeam() + ")";
    }

    @SuppressWarnings("all")
    
    public ThreadInputDto(final String name, final ArticleInputDto firstArticle, final Long board, final Optional<Long> event, final Optional<Long> team) {
        this.name = name;
        this.firstArticle = firstArticle;
        this.board = board;
        this.event = event;
        this.team = team;
    }
    //</editor-fold>
}
