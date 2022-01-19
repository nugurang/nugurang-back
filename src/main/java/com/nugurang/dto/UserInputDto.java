package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;

public class UserInputDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String biography;
    @NotNull
    private Optional<Long> image;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserInputDtoBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String email;
        @SuppressWarnings("all")
        
        private String biography;
        @SuppressWarnings("all")
        
        private Optional<Long> image;

        @SuppressWarnings("all")
        
        UserInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserInputDto.UserInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserInputDto.UserInputDtoBuilder email(final String email) {
            this.email = email;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserInputDto.UserInputDtoBuilder biography(final String biography) {
            this.biography = biography;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserInputDto.UserInputDtoBuilder image(final Optional<Long> image) {
            this.image = image;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserInputDto build() {
            return new UserInputDto(this.name, this.email, this.biography, this.image);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserInputDto.UserInputDtoBuilder(name=" + this.name + ", email=" + this.email + ", biography=" + this.biography + ", image=" + this.image + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserInputDto.UserInputDtoBuilder builder() {
        return new UserInputDto.UserInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public String getEmail() {
        return this.email;
    }

    @SuppressWarnings("all")
    
    public String getBiography() {
        return this.biography;
    }

    @SuppressWarnings("all")
    
    public Optional<Long> getImage() {
        return this.image;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setEmail(final String email) {
        this.email = email;
    }

    @SuppressWarnings("all")
    
    public void setBiography(final String biography) {
        this.biography = biography;
    }

    @SuppressWarnings("all")
    
    public void setImage(final Optional<Long> image) {
        this.image = image;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserInputDto)) return false;
        final UserInputDto other = (UserInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$biography = this.getBiography();
        final Object other$biography = other.getBiography();
        if (this$biography == null ? other$biography != null : !this$biography.equals(other$biography)) return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof UserInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $biography = this.getBiography();
        result = result * PRIME + ($biography == null ? 43 : $biography.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "UserInputDto(name=" + this.getName() + ", email=" + this.getEmail() + ", biography=" + this.getBiography() + ", image=" + this.getImage() + ")";
    }

    @SuppressWarnings("all")
    
    public UserInputDto(final String name, final String email, final String biography, final Optional<Long> image) {
        this.name = name;
        this.email = email;
        this.biography = biography;
        this.image = image;
    }
    //</editor-fold>
}
