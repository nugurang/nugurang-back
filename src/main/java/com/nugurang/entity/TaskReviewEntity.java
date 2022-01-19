package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "task_review", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "task"})})
public class TaskReviewEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Integer honor;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class TaskReviewEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private Integer honor;
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private TaskEntity task;

        @SuppressWarnings("all")
        
        TaskReviewEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public TaskReviewEntity.TaskReviewEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskReviewEntity.TaskReviewEntityBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskReviewEntity.TaskReviewEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskReviewEntity.TaskReviewEntityBuilder task(final TaskEntity task) {
            this.task = task;
            return this;
        }

        @SuppressWarnings("all")
        
        public TaskReviewEntity build() {
            return new TaskReviewEntity(this.id, this.honor, this.user, this.task);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "TaskReviewEntity.TaskReviewEntityBuilder(id=" + this.id + ", honor=" + this.honor + ", user=" + this.user + ", task=" + this.task + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static TaskReviewEntity.TaskReviewEntityBuilder builder() {
        return new TaskReviewEntity.TaskReviewEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public TaskReviewEntity(final Long id, final Integer honor, final UserEntity user, final TaskEntity task) {
        this.id = id;
        this.honor = honor;
        this.user = user;
        this.task = task;
    }

    @SuppressWarnings("all")
    
    protected TaskReviewEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public Integer getHonor() {
        return this.honor;
    }

    @SuppressWarnings("all")
    
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    
    public TaskEntity getTask() {
        return this.task;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setHonor(final Integer honor) {
        this.honor = honor;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    
    public void setTask(final TaskEntity task) {
        this.task = task;
    }
    //</editor-fold>
}
