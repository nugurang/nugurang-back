package com.nugurang.entity;

import com.nugurang.dto.VoteDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "article", "vote_type"})})
public class VoteEntity implements BaseEntity<VoteDto> {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;
    @ManyToOne
    @JoinColumn(name = "vote_type", nullable = false)
    private VoteTypeEntity voteType;

    public VoteDto toDto() {
        return VoteDto.builder().id(id).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class VoteEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private ArticleEntity article;
        @SuppressWarnings("all")
        
        private VoteTypeEntity voteType;

        @SuppressWarnings("all")
        
        VoteEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public VoteEntity.VoteEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteEntity.VoteEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteEntity.VoteEntityBuilder article(final ArticleEntity article) {
            this.article = article;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteEntity.VoteEntityBuilder voteType(final VoteTypeEntity voteType) {
            this.voteType = voteType;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteEntity build() {
            return new VoteEntity(this.id, this.user, this.article, this.voteType);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "VoteEntity.VoteEntityBuilder(id=" + this.id + ", user=" + this.user + ", article=" + this.article + ", voteType=" + this.voteType + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static VoteEntity.VoteEntityBuilder builder() {
        return new VoteEntity.VoteEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public VoteEntity(final Long id, final UserEntity user, final ArticleEntity article, final VoteTypeEntity voteType) {
        this.id = id;
        this.user = user;
        this.article = article;
        this.voteType = voteType;
    }

    @SuppressWarnings("all")
    
    protected VoteEntity() {
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
    
    public ArticleEntity getArticle() {
        return this.article;
    }

    @SuppressWarnings("all")
    
    public VoteTypeEntity getVoteType() {
        return this.voteType;
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
    
    public void setArticle(final ArticleEntity article) {
        this.article = article;
    }

    @SuppressWarnings("all")
    
    public void setVoteType(final VoteTypeEntity voteType) {
        this.voteType = voteType;
    }
    //</editor-fold>
}
