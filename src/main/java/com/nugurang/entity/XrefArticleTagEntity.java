package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_article_tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"article", "tag"})})
public class XrefArticleTagEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;
    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tag;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefArticleTagEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private ArticleEntity article;
        @SuppressWarnings("all")
        
        private TagEntity tag;

        @SuppressWarnings("all")
        
        XrefArticleTagEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefArticleTagEntity.XrefArticleTagEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefArticleTagEntity.XrefArticleTagEntityBuilder article(final ArticleEntity article) {
            this.article = article;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefArticleTagEntity.XrefArticleTagEntityBuilder tag(final TagEntity tag) {
            this.tag = tag;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefArticleTagEntity build() {
            return new XrefArticleTagEntity(this.id, this.article, this.tag);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefArticleTagEntity.XrefArticleTagEntityBuilder(id=" + this.id + ", article=" + this.article + ", tag=" + this.tag + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefArticleTagEntity.XrefArticleTagEntityBuilder builder() {
        return new XrefArticleTagEntity.XrefArticleTagEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public XrefArticleTagEntity(final Long id, final ArticleEntity article, final TagEntity tag) {
        this.id = id;
        this.article = article;
        this.tag = tag;
    }

    @SuppressWarnings("all")
    
    protected XrefArticleTagEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public ArticleEntity getArticle() {
        return this.article;
    }

    @SuppressWarnings("all")
    
    public TagEntity getTag() {
        return this.tag;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setArticle(final ArticleEntity article) {
        this.article = article;
    }

    @SuppressWarnings("all")
    
    public void setTag(final TagEntity tag) {
        this.tag = tag;
    }
    //</editor-fold>
}
