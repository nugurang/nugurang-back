package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class UserDto {
    @NotNull
    private Long id;
    @NotNull
    private String oauth2Provider;
    @NotNull
    private String oauth2Id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    private String biography;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String oauth2Provider;
        @SuppressWarnings("all")
        
        private String oauth2Id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String email;
        @SuppressWarnings("all")
        
        private String biography;

        @SuppressWarnings("all")
        
        UserDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserDto.UserDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserDto.UserDtoBuilder oauth2Provider(final String oauth2Provider) {
            this.oauth2Provider = oauth2Provider;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserDto.UserDtoBuilder oauth2Id(final String oauth2Id) {
            this.oauth2Id = oauth2Id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserDto.UserDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserDto.UserDtoBuilder email(final String email) {
            this.email = email;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserDto.UserDtoBuilder biography(final String biography) {
            this.biography = biography;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserDto build() {
            return new UserDto(this.id, this.oauth2Provider, this.oauth2Id, this.name, this.email, this.biography);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserDto.UserDtoBuilder(id=" + this.id + ", oauth2Provider=" + this.oauth2Provider + ", oauth2Id=" + this.oauth2Id + ", name=" + this.name + ", email=" + this.email + ", biography=" + this.biography + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserDto.UserDtoBuilder builder() {
        return new UserDto.UserDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getOauth2Provider() {
        return this.oauth2Provider;
    }

    @SuppressWarnings("all")
    
    public String getOauth2Id() {
        return this.oauth2Id;
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
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setOauth2Provider(final String oauth2Provider) {
        this.oauth2Provider = oauth2Provider;
    }

    @SuppressWarnings("all")
    
    public void setOauth2Id(final String oauth2Id) {
        this.oauth2Id = oauth2Id;
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

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto)) return false;
        final UserDto other = (UserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$oauth2Provider = this.getOauth2Provider();
        final Object other$oauth2Provider = other.getOauth2Provider();
        if (this$oauth2Provider == null ? other$oauth2Provider != null : !this$oauth2Provider.equals(other$oauth2Provider)) return false;
        final Object this$oauth2Id = this.getOauth2Id();
        final Object other$oauth2Id = other.getOauth2Id();
        if (this$oauth2Id == null ? other$oauth2Id != null : !this$oauth2Id.equals(other$oauth2Id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$biography = this.getBiography();
        final Object other$biography = other.getBiography();
        if (this$biography == null ? other$biography != null : !this$biography.equals(other$biography)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof UserDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $oauth2Provider = this.getOauth2Provider();
        result = result * PRIME + ($oauth2Provider == null ? 43 : $oauth2Provider.hashCode());
        final Object $oauth2Id = this.getOauth2Id();
        result = result * PRIME + ($oauth2Id == null ? 43 : $oauth2Id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $biography = this.getBiography();
        result = result * PRIME + ($biography == null ? 43 : $biography.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "UserDto(id=" + this.getId() + ", oauth2Provider=" + this.getOauth2Provider() + ", oauth2Id=" + this.getOauth2Id() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", biography=" + this.getBiography() + ")";
    }

    @SuppressWarnings("all")
    
    public UserDto(final Long id, final String oauth2Provider, final String oauth2Id, final String name, final String email, final String biography) {
        this.id = id;
        this.oauth2Provider = oauth2Provider;
        this.oauth2Id = oauth2Id;
        this.name = name;
        this.email = email;
        this.biography = biography;
    }
    //</editor-fold>
}
