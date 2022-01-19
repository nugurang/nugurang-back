package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_user_task", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "task"})})
public class XrefUserTaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;

    public XrefUserTaskEntity(Integer honor, UserEntity user, TaskEntity task) {
        this.user = user;
        this.task = task;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefUserTaskEntityBuilder {
        @SuppressWarnings("all")
        
        private Integer honor;
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private TaskEntity task;

        @SuppressWarnings("all")
        
        XrefUserTaskEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefUserTaskEntity.XrefUserTaskEntityBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserTaskEntity.XrefUserTaskEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserTaskEntity.XrefUserTaskEntityBuilder task(final TaskEntity task) {
            this.task = task;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefUserTaskEntity build() {
            return new XrefUserTaskEntity(this.honor, this.user, this.task);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefUserTaskEntity.XrefUserTaskEntityBuilder(honor=" + this.honor + ", user=" + this.user + ", task=" + this.task + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefUserTaskEntity.XrefUserTaskEntityBuilder builder() {
        return new XrefUserTaskEntity.XrefUserTaskEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected XrefUserTaskEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
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
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    
    public void setTask(final TaskEntity task) {
        this.task = task;
    }
    //</editor-fold>
}
