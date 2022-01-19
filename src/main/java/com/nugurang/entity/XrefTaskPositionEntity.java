package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_task_position", uniqueConstraints = {@UniqueConstraint(columnNames = {"task", "position"})})
public class XrefTaskPositionEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;
    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class XrefTaskPositionEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private TaskEntity task;
        @SuppressWarnings("all")
        private PositionEntity position;

        @SuppressWarnings("all")
        XrefTaskPositionEntityBuilder() {
        }

        @SuppressWarnings("all")
        public XrefTaskPositionEntity.XrefTaskPositionEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public XrefTaskPositionEntity.XrefTaskPositionEntityBuilder task(final TaskEntity task) {
            this.task = task;
            return this;
        }

        @SuppressWarnings("all")
        public XrefTaskPositionEntity.XrefTaskPositionEntityBuilder position(final PositionEntity position) {
            this.position = position;
            return this;
        }

        @SuppressWarnings("all")
        public XrefTaskPositionEntity build() {
            return new XrefTaskPositionEntity(this.id, this.task, this.position);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "XrefTaskPositionEntity.XrefTaskPositionEntityBuilder(id=" + this.id + ", task=" + this.task + ", position=" + this.position + ")";
        }
    }

    @SuppressWarnings("all")
    public static XrefTaskPositionEntity.XrefTaskPositionEntityBuilder builder() {
        return new XrefTaskPositionEntity.XrefTaskPositionEntityBuilder();
    }

    @SuppressWarnings("all")
    public XrefTaskPositionEntity(final Long id, final TaskEntity task, final PositionEntity position) {
        this.id = id;
        this.task = task;
        this.position = position;
    }

    @SuppressWarnings("all")
    protected XrefTaskPositionEntity() {
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public TaskEntity getTask() {
        return this.task;
    }

    @SuppressWarnings("all")
    public PositionEntity getPosition() {
        return this.position;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setTask(final TaskEntity task) {
        this.task = task;
    }

    @SuppressWarnings("all")
    public void setPosition(final PositionEntity position) {
        this.position = position;
    }
    //</editor-fold>
}
