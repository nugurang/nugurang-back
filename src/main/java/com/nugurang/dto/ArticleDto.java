package com.nugurang.dto;

import java.time.OffsetDateTime;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public class ArticleDto {
    @NotNull
    private Long id;
    @NotNull
    private Optional<String> title;
    @NotNull
    private String content;
    @NotNull
    private Long viewCount;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime modifiedAt;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ArticleDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private Optional<String> title;
        @SuppressWarnings("all")
        
        private String content;
        @SuppressWarnings("all")
        
        private Long viewCount;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private OffsetDateTime modifiedAt;

        @SuppressWarnings("all")
        
        ArticleDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public ArticleDto.ArticleDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleDto.ArticleDtoBuilder title(final Optional<String> title) {
            this.title = title;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleDto.ArticleDtoBuilder content(final String content) {
            this.content = content;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleDto.ArticleDtoBuilder viewCount(final Long viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleDto.ArticleDtoBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleDto.ArticleDtoBuilder modifiedAt(final OffsetDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public ArticleDto build() {
            return new ArticleDto(this.id, this.title, this.content, this.viewCount, this.createdAt, this.modifiedAt);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ArticleDto.ArticleDtoBuilder(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ", viewCount=" + this.viewCount + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ArticleDto.ArticleDtoBuilder builder() {
        return new ArticleDto.ArticleDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public Optional<String> getTitle() {
        return this.title;
    }

    @SuppressWarnings("all")
    
    public String getContent() {
        return this.content;
    }

    @SuppressWarnings("all")
    
    public Long getViewCount() {
        return this.viewCount;
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
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setTitle(final Optional<String> title) {
        this.title = title;
    }

    @SuppressWarnings("all")
    
    public void setContent(final String content) {
        this.content = content;
    }

    @SuppressWarnings("all")
    
    public void setViewCount(final Long viewCount) {
        this.viewCount = viewCount;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setModifiedAt(final OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ArticleDto)) return false;
        final ArticleDto other = (ArticleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$viewCount = this.getViewCount();
        final Object other$viewCount = other.getViewCount();
        if (this$viewCount == null ? other$viewCount != null : !this$viewCount.equals(other$viewCount)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$modifiedAt = this.getModifiedAt();
        final Object other$modifiedAt = other.getModifiedAt();
        if (this$modifiedAt == null ? other$modifiedAt != null : !this$modifiedAt.equals(other$modifiedAt)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof ArticleDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $viewCount = this.getViewCount();
        result = result * PRIME + ($viewCount == null ? 43 : $viewCount.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $modifiedAt = this.getModifiedAt();
        result = result * PRIME + ($modifiedAt == null ? 43 : $modifiedAt.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "ArticleDto(id=" + this.getId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", viewCount=" + this.getViewCount() + ", createdAt=" + this.getCreatedAt() + ", modifiedAt=" + this.getModifiedAt() + ")";
    }

    @SuppressWarnings("all")
    
    public ArticleDto(final Long id, final Optional<String> title, final String content, final Long viewCount, final OffsetDateTime createdAt, final OffsetDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    //</editor-fold>
}
