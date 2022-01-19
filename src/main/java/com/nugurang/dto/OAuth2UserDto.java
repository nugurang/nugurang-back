package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class OAuth2UserDto {
    @NotNull
    private String id;
    @NotNull
    private String provider;
    @NotNull
    private String name;
    @NotNull
    private String email;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class OAuth2UserDtoBuilder {
        @SuppressWarnings("all")
        
        private String id;
        @SuppressWarnings("all")
        
        private String provider;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String email;

        @SuppressWarnings("all")
        
        OAuth2UserDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public OAuth2UserDto.OAuth2UserDtoBuilder id(final String id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2UserDto.OAuth2UserDtoBuilder provider(final String provider) {
            this.provider = provider;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2UserDto.OAuth2UserDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2UserDto.OAuth2UserDtoBuilder email(final String email) {
            this.email = email;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2UserDto build() {
            return new OAuth2UserDto(this.id, this.provider, this.name, this.email);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "OAuth2UserDto.OAuth2UserDtoBuilder(id=" + this.id + ", provider=" + this.provider + ", name=" + this.name + ", email=" + this.email + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static OAuth2UserDto.OAuth2UserDtoBuilder builder() {
        return new OAuth2UserDto.OAuth2UserDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getProvider() {
        return this.provider;
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
    
    public void setId(final String id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setProvider(final String provider) {
        this.provider = provider;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OAuth2UserDto)) return false;
        final OAuth2UserDto other = (OAuth2UserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$provider = this.getProvider();
        final Object other$provider = other.getProvider();
        if (this$provider == null ? other$provider != null : !this$provider.equals(other$provider)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof OAuth2UserDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $provider = this.getProvider();
        result = result * PRIME + ($provider == null ? 43 : $provider.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "OAuth2UserDto(id=" + this.getId() + ", provider=" + this.getProvider() + ", name=" + this.getName() + ", email=" + this.getEmail() + ")";
    }

    @SuppressWarnings("all")
    
    public OAuth2UserDto(final String id, final String provider, final String name, final String email) {
        this.id = id;
        this.provider = provider;
        this.name = name;
        this.email = email;
    }
    //</editor-fold>
}
