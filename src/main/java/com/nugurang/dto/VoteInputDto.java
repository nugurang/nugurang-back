package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class VoteInputDto {
    @NotNull
    private Long article;
    @NotNull
    private Long voteType;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class VoteInputDtoBuilder {
        @SuppressWarnings("all")
        
        private Long article;
        @SuppressWarnings("all")
        
        private Long voteType;

        @SuppressWarnings("all")
        
        VoteInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public VoteInputDto.VoteInputDtoBuilder article(final Long article) {
            this.article = article;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteInputDto.VoteInputDtoBuilder voteType(final Long voteType) {
            this.voteType = voteType;
            return this;
        }

        @SuppressWarnings("all")
        
        public VoteInputDto build() {
            return new VoteInputDto(this.article, this.voteType);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "VoteInputDto.VoteInputDtoBuilder(article=" + this.article + ", voteType=" + this.voteType + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static VoteInputDto.VoteInputDtoBuilder builder() {
        return new VoteInputDto.VoteInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getArticle() {
        return this.article;
    }

    @SuppressWarnings("all")
    
    public Long getVoteType() {
        return this.voteType;
    }

    @SuppressWarnings("all")
    
    public void setArticle(final Long article) {
        this.article = article;
    }

    @SuppressWarnings("all")
    
    public void setVoteType(final Long voteType) {
        this.voteType = voteType;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof VoteInputDto)) return false;
        final VoteInputDto other = (VoteInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$article = this.getArticle();
        final Object other$article = other.getArticle();
        if (this$article == null ? other$article != null : !this$article.equals(other$article)) return false;
        final Object this$voteType = this.getVoteType();
        final Object other$voteType = other.getVoteType();
        if (this$voteType == null ? other$voteType != null : !this$voteType.equals(other$voteType)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof VoteInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $article = this.getArticle();
        result = result * PRIME + ($article == null ? 43 : $article.hashCode());
        final Object $voteType = this.getVoteType();
        result = result * PRIME + ($voteType == null ? 43 : $voteType.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "VoteInputDto(article=" + this.getArticle() + ", voteType=" + this.getVoteType() + ")";
    }

    @SuppressWarnings("all")
    
    public VoteInputDto(final Long article, final Long voteType) {
        this.article = article;
        this.voteType = voteType;
    }
    //</editor-fold>
}
