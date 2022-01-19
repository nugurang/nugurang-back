package com.nugurang.entity;

import com.nugurang.dto.TaskDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "task", uniqueConstraints = {@UniqueConstraint(columnNames = {"work", "name"}), @UniqueConstraint(columnNames = {"work", "name", "order"})})
public class TaskEntity implements BaseEntity<TaskDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private Integer order;
    @Column(nullable = false)
    private Integer difficulty;
    @ManyToOne
    @JoinColumn(name = "work", nullable = false)
    private WorkEntity work;
    @ManyToOne
    @JoinColumn(name = "progress", nullable = false)
    private ProgressEntity progress;

    public TaskDto toDto() {
        return TaskDto.builder().id(id).name(name).order(order).difficulty(difficulty).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class TaskEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String name;
        @SuppressWarnings("all")
        private Integer order;
        @SuppressWarnings("all")
        private Integer difficulty;
        @SuppressWarnings("all")
        private WorkEntity work;
        @SuppressWarnings("all")
        private ProgressEntity progress;

        @SuppressWarnings("all")
        TaskEntityBuilder() {
        }

        @SuppressWarnings("all")
        public TaskEntity.TaskEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public TaskEntity.TaskEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        public TaskEntity.TaskEntityBuilder order(final Integer order) {
            this.order = order;
            return this;
        }

        @SuppressWarnings("all")
        public TaskEntity.TaskEntityBuilder difficulty(final Integer difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        @SuppressWarnings("all")
        public TaskEntity.TaskEntityBuilder work(final WorkEntity work) {
            this.work = work;
            return this;
        }

        @SuppressWarnings("all")
        public TaskEntity.TaskEntityBuilder progress(final ProgressEntity progress) {
            this.progress = progress;
            return this;
        }

        @SuppressWarnings("all")
        public TaskEntity build() {
            return new TaskEntity(this.id, this.name, this.order, this.difficulty, this.work, this.progress);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "TaskEntity.TaskEntityBuilder(id=" + this.id + ", name=" + this.name + ", order=" + this.order + ", difficulty=" + this.difficulty + ", work=" + this.work + ", progress=" + this.progress + ")";
        }
    }

    @SuppressWarnings("all")
    public static TaskEntity.TaskEntityBuilder builder() {
        return new TaskEntity.TaskEntityBuilder();
    }

    @SuppressWarnings("all")
    public TaskEntity(final Long id, final String name, final Integer order, final Integer difficulty, final WorkEntity work, final ProgressEntity progress) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.difficulty = difficulty;
        this.work = work;
        this.progress = progress;
    }

    @SuppressWarnings("all")
    protected TaskEntity() {
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
    public WorkEntity getWork() {
        return this.work;
    }

    @SuppressWarnings("all")
    public ProgressEntity getProgress() {
        return this.progress;
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

    @SuppressWarnings("all")
    public void setWork(final WorkEntity work) {
        this.work = work;
    }

    @SuppressWarnings("all")
    public void setProgress(final ProgressEntity progress) {
        this.progress = progress;
    }
    //</editor-fold>
}
