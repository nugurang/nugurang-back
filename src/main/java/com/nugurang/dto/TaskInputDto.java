package com.nugurang.dto;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public class TaskInputDto {
    @NotNull
    private String name;
    @NotNull
    private Optional<Integer> difficulty;
    @NotNull
    private Optional<Integer> order;
    @NotNull
    private Optional<Long> progress;
    @NotNull
    private List<Long> users;
    @NotNull
    private List<Long> positions;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TaskInputDtoBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Optional<Integer> difficulty;
        @SuppressWarnings("all")
        
        private Optional<Integer> order;
        @SuppressWarnings("all")
        
        private Optional<Long> progress;
        @SuppressWarnings("all")
        
        private List<Long> users;
        @SuppressWarnings("all")
        
        private List<Long> positions;

        @SuppressWarnings("all")
        
        TaskInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public TaskInputDto.TaskInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskInputDto.TaskInputDtoBuilder difficulty(final Optional<Integer> difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskInputDto.TaskInputDtoBuilder order(final Optional<Integer> order) {
            this.order = order;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskInputDto.TaskInputDtoBuilder progress(final Optional<Long> progress) {
            this.progress = progress;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskInputDto.TaskInputDtoBuilder users(final List<Long> users) {
            this.users = users;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskInputDto.TaskInputDtoBuilder positions(final List<Long> positions) {
            this.positions = positions;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskInputDto build() {
            return new TaskInputDto(this.name, this.difficulty, this.order, this.progress, this.users, this.positions);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TaskInputDto.TaskInputDtoBuilder(name=" + this.name + ", difficulty=" + this.difficulty + ", order=" + this.order + ", progress=" + this.progress + ", users=" + this.users + ", positions=" + this.positions + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TaskInputDto.TaskInputDtoBuilder builder() {
        return new TaskInputDto.TaskInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public Optional<Integer> getDifficulty() {
        return this.difficulty;
    }

    @SuppressWarnings("all")
    
    public Optional<Integer> getOrder() {
        return this.order;
    }

    @SuppressWarnings("all")
    
    public Optional<Long> getProgress() {
        return this.progress;
    }

    @SuppressWarnings("all")
    
    public List<Long> getUsers() {
        return this.users;
    }

    @SuppressWarnings("all")
    
    public List<Long> getPositions() {
        return this.positions;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setDifficulty(final Optional<Integer> difficulty) {
        this.difficulty = difficulty;
    }

    @SuppressWarnings("all")
    
    public void setOrder(final Optional<Integer> order) {
        this.order = order;
    }

    @SuppressWarnings("all")
    
    public void setProgress(final Optional<Long> progress) {
        this.progress = progress;
    }

    @SuppressWarnings("all")
    
    public void setUsers(final List<Long> users) {
        this.users = users;
    }

    @SuppressWarnings("all")
    
    public void setPositions(final List<Long> positions) {
        this.positions = positions;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskInputDto)) return false;
        final TaskInputDto other = (TaskInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$difficulty = this.getDifficulty();
        final Object other$difficulty = other.getDifficulty();
        if (this$difficulty == null ? other$difficulty != null : !this$difficulty.equals(other$difficulty)) return false;
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        if (this$order == null ? other$order != null : !this$order.equals(other$order)) return false;
        final Object this$progress = this.getProgress();
        final Object other$progress = other.getProgress();
        if (this$progress == null ? other$progress != null : !this$progress.equals(other$progress)) return false;
        final Object this$users = this.getUsers();
        final Object other$users = other.getUsers();
        if (this$users == null ? other$users != null : !this$users.equals(other$users)) return false;
        final Object this$positions = this.getPositions();
        final Object other$positions = other.getPositions();
        if (this$positions == null ? other$positions != null : !this$positions.equals(other$positions)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof TaskInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $difficulty = this.getDifficulty();
        result = result * PRIME + ($difficulty == null ? 43 : $difficulty.hashCode());
        final Object $order = this.getOrder();
        result = result * PRIME + ($order == null ? 43 : $order.hashCode());
        final Object $progress = this.getProgress();
        result = result * PRIME + ($progress == null ? 43 : $progress.hashCode());
        final Object $users = this.getUsers();
        result = result * PRIME + ($users == null ? 43 : $users.hashCode());
        final Object $positions = this.getPositions();
        result = result * PRIME + ($positions == null ? 43 : $positions.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "TaskInputDto(name=" + this.getName() + ", difficulty=" + this.getDifficulty() + ", order=" + this.getOrder() + ", progress=" + this.getProgress() + ", users=" + this.getUsers() + ", positions=" + this.getPositions() + ")";
    }

    @SuppressWarnings("all")
    
    public TaskInputDto(final String name, final Optional<Integer> difficulty, final Optional<Integer> order, final Optional<Long> progress, final List<Long> users, final List<Long> positions) {
        this.name = name;
        this.difficulty = difficulty;
        this.order = order;
        this.progress = progress;
        this.users = users;
        this.positions = positions;
    }
    //</editor-fold>
}
