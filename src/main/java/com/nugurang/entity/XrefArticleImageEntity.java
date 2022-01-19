package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_article_image", uniqueConstraints = {@UniqueConstraint(columnNames = {"article", "image"})})
public class XrefArticleImageEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;
    @ManyToOne
    @JoinColumn(name = "image", nullable = false)
    private ImageEntity image;

    public XrefArticleImageEntity(ArticleEntity article, ImageEntity image) {
        this.article = article;
        this.image = image;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefArticleImageEntityBuilder {
        @SuppressWarnings("all")
        
        private ArticleEntity article;
        @SuppressWarnings("all")
        
        private ImageEntity image;

        @SuppressWarnings("all")
        
        XrefArticleImageEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefArticleImageEntity.XrefArticleImageEntityBuilder article(final ArticleEntity article) {
            this.article = article;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefArticleImageEntity.XrefArticleImageEntityBuilder image(final ImageEntity image) {
            this.image = image;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefArticleImageEntity build() {
            return new XrefArticleImageEntity(this.article, this.image);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefArticleImageEntity.XrefArticleImageEntityBuilder(article=" + this.article + ", image=" + this.image + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefArticleImageEntity.XrefArticleImageEntityBuilder builder() {
        return new XrefArticleImageEntity.XrefArticleImageEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected XrefArticleImageEntity() {
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
    
    public ImageEntity getImage() {
        return this.image;
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
    
    public void setImage(final ImageEntity image) {
        this.image = image;
    }
    //</editor-fold>
}
