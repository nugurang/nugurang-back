package com.nugurang.entity;

import com.nugurang.dto.ArticleDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "article")
public class ArticleEntity implements BaseEntity<ArticleDto> {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(nullable = false)
    private String content;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    private ThreadEntity thread;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "parent")
    private ArticleEntity parent;

    @Override
    public ArticleDto toDto() {
        return new ArticleDto(
            id,
            title,
            content,
            getCreatedAt(),
            getModifiedAt()
        );
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ArticleEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String title;
        @SuppressWarnings("all")
        
        private String content;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private OffsetDateTime modifiedAt;
        @SuppressWarnings("all")
        
        private ThreadEntity thread;
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private ArticleEntity parent;

        @SuppressWarnings("all")
        
        ArticleEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder title(final String title) {
            this.title = title;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder content(final String content) {
            this.content = content;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder modifiedAt(final OffsetDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder thread(final ThreadEntity thread) {
            this.thread = thread;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity.ArticleEntityBuilder parent(final ArticleEntity parent) {
            this.parent = parent;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleEntity build() {
            return new ArticleEntity(this.id, this.title, this.content, this.createdAt, this.modifiedAt, this.thread, this.user, this.parent);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ArticleEntity.ArticleEntityBuilder(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", thread=" + this.thread + ", user=" + this.user + ", parent=" + this.parent + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ArticleEntity.ArticleEntityBuilder builder() {
        return new ArticleEntity.ArticleEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public ArticleEntity(final Long id, final String title, final String content, final OffsetDateTime createdAt, final OffsetDateTime modifiedAt, final ThreadEntity thread, final UserEntity user, final ArticleEntity parent) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.thread = thread;
        this.user = user;
        this.parent = parent;
    }

    @SuppressWarnings("all")
    
    protected ArticleEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getTitle() {
        return this.title;
    }

    @SuppressWarnings("all")
    
    public String getContent() {
        return this.content;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    @SuppressWarnings("all")
    
    public ThreadEntity getThread() {
        return this.thread;
    }

    @SuppressWarnings("all")
    
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    
    public ArticleEntity getParent() {
        return this.parent;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setTitle(final String title) {
        this.title = title;
    }

    @SuppressWarnings("all")
    
    public void setContent(final String content) {
        this.content = content;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setModifiedAt(final OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @SuppressWarnings("all")
    
    public void setThread(final ThreadEntity thread) {
        this.thread = thread;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    
    public void setParent(final ArticleEntity parent) {
        this.parent = parent;
    }
    //</editor-fold>
}
