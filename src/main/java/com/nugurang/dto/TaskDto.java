package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class TaskDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer order;
    @NotNull
    private Integer difficulty;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TaskDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Integer order;
        @SuppressWarnings("all")
        
        private Integer difficulty;

        @SuppressWarnings("all")
        
        TaskDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public TaskDto.TaskDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskDto.TaskDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskDto.TaskDtoBuilder order(final Integer order) {
            this.order = order;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskDto.TaskDtoBuilder difficulty(final Integer difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskDto build() {
            return new TaskDto(this.id, this.name, this.order, this.difficulty);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TaskDto.TaskDtoBuilder(id=" + this.id + ", name=" + this.name + ", order=" + this.order + ", difficulty=" + this.difficulty + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TaskDto.TaskDtoBuilder builder() {
        return new TaskDto.TaskDtoBuilder();
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
    
    public Integer getOrder() {
        return this.order;
    }

    @SuppressWarnings("all")
    
    public Integer getDifficulty() {
        return this.difficulty;
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
    
    public void setOrder(final Integer order) {
        this.order = order;
    }

    @SuppressWarnings("all")
    
    public void setDifficulty(final Integer difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskDto)) return false;
        final TaskDto other = (TaskDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        if (this$order == null ? other$order != null : !this$order.equals(other$order)) return false;
        final Object this$difficulty = this.getDifficulty();
        final Object other$difficulty = other.getDifficulty();
        if (this$difficulty == null ? other$difficulty != null : !this$difficulty.equals(other$difficulty)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof TaskDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $order = this.getOrder();
        result = result * PRIME + ($order == null ? 43 : $order.hashCode());
        final Object $difficulty = this.getDifficulty();
        result = result * PRIME + ($difficulty == null ? 43 : $difficulty.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "TaskDto(id=" + this.getId() + ", name=" + this.getName() + ", order=" + this.getOrder() + ", difficulty=" + this.getDifficulty() + ")";
    }

    @SuppressWarnings("all")
    
    public TaskDto(final Long id, final String name, final Integer order, final Integer difficulty) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.difficulty = difficulty;
    }
    //</editor-fold>
}
