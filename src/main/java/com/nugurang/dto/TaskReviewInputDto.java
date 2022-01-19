package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class TaskReviewInputDto {
    @NotNull
    private Integer honor;
    @NotNull
    private Long task;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TaskReviewInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Integer honor;
        @SuppressWarnings("all")
        
        private Long task;

        @SuppressWarnings("all")
        
        TaskReviewInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public TaskReviewInputDto.TaskReviewInputDtoBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskReviewInputDto.TaskReviewInputDtoBuilder task(final Long task) {
            this.task = task;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskReviewInputDto build() {
            return new TaskReviewInputDto(this.honor, this.task);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TaskReviewInputDto.TaskReviewInputDtoBuilder(honor=" + this.honor + ", task=" + this.task + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TaskReviewInputDto.TaskReviewInputDtoBuilder builder() {
        return new TaskReviewInputDto.TaskReviewInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Integer getHonor() {
        return this.honor;
    }

    @SuppressWarnings("all")
    
    public Long getTask() {
        return this.task;
    }

    @SuppressWarnings("all")
    
    public void setHonor(final Integer honor) {
        this.honor = honor;
    }

    @SuppressWarnings("all")
    
    public void setTask(final Long task) {
        this.task = task;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskReviewInputDto)) return false;
        final TaskReviewInputDto other = (TaskReviewInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$honor = this.getHonor();
        final Object other$honor = other.getHonor();
        if (this$honor == null ? other$honor != null : !this$honor.equals(other$honor)) return false;
        final Object this$task = this.getTask();
        final Object other$task = other.getTask();
        if (this$task == null ? other$task != null : !this$task.equals(other$task)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof TaskReviewInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $honor = this.getHonor();
        result = result * PRIME + ($honor == null ? 43 : $honor.hashCode());
        final Object $task = this.getTask();
        result = result * PRIME + ($task == null ? 43 : $task.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "TaskReviewInputDto(honor=" + this.getHonor() + ", task=" + this.getTask() + ")";
    }

    @SuppressWarnings("all")
    
    public TaskReviewInputDto(final Integer honor, final Long task) {
        this.honor = honor;
        this.task = task;
    }
    //</editor-fold>
}
