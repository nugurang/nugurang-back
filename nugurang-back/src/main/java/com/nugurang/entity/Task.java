package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"work", "name"}),
    @UniqueConstraint(columnNames = {"work", "name", "order"})
}) 
public class Task implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer order;

    @Column(nullable = false)
    private Integer difficulty;

    @ManyToOne
    @JoinColumn(name = "work", nullable = false)
    private Work work;

    @ManyToOne
    @JoinColumn(name = "progress", nullable = false)
    private Progress progress;

    public Task(String name, Integer order, Integer difficulty, Work work, Progress progress) {
        this.name = name;
        this.order = order;
        this.work = work;
        this.progress = progress;
    }
}