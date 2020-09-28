package com.nugurang.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Article extends DateAudit implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long viewCount;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Thread thread;

    @ManyToOne
    @JoinColumn
    private Article parent;

    public Article(String title, String content, Thread thread) {
        this.title = title;
        this.content = content;
        this.viewCount = Long.valueOf(0);
        this.thread = thread;
    }
}
