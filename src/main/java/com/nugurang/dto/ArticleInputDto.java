package com.nugurang.dto;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public class ArticleInputDto {
    @NotNull
    private String content;
    @NotNull
    private Optional<String> title;
    @NotNull
    private List<Long> images;

    public ArticleInputDto(@NotNull String content, @NotNull Optional<String> title, @NotNull List<Long> images) {
        this.content = content;
        this.title = title;
        this.images = images;
    }

    public static ArticleInputDtoBuilder builder() {
        return new ArticleInputDtoBuilder();
    }

    public @NotNull String getContent() {
        return this.content;
    }

    public @NotNull Optional<String> getTitle() {
        return this.title;
    }

    public @NotNull List<Long> getImages() {
        return this.images;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    public void setTitle(@NotNull Optional<String> title) {
        this.title = title;
    }

    public void setImages(@NotNull List<Long> images) {
        this.images = images;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ArticleInputDto)) return false;
        final ArticleInputDto other = (ArticleInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$images = this.getImages();
        final Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArticleInputDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $images = this.getImages();
        result = result * PRIME + ($images == null ? 43 : $images.hashCode());
        return result;
    }

    public String toString() {
        return "ArticleInputDto(content=" + this.getContent() + ", title=" + this.getTitle() + ", images=" + this.getImages() + ")";
    }

    public static class ArticleInputDtoBuilder {
        private @NotNull String content;
        private @NotNull Optional<String> title;
        private @NotNull List<Long> images;

        ArticleInputDtoBuilder() {
        }

        public ArticleInputDtoBuilder content(@NotNull String content) {
            this.content = content;
            return this;
        }

        public ArticleInputDtoBuilder title(@NotNull Optional<String> title) {
            this.title = title;
            return this;
        }

        public ArticleInputDtoBuilder images(@NotNull List<Long> images) {
            this.images = images;
            return this;
        }

        public ArticleInputDto build() {
            return new ArticleInputDto(content, title, images);
        }

        public String toString() {
            return "ArticleInputDto.ArticleInputDtoBuilder(content=" + this.content + ", title=" + this.title + ", images=" + this.images + ")";
        }
    }
}