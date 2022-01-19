package com.nugurang.service;

import java.util.Map;
import lombok.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

class OAuth2Attributes {
    @NonNull
    private String name;
    @NonNull
    private String email;

    public static OAuth2Attributes ofGithub(Map<String, Object> oauth2Attributes) {
        return OAuth2Attributes.builder().name((String) oauth2Attributes.get("login")).email((String) oauth2Attributes.get("email")).build();
    }

    public static OAuth2Attributes ofKakao(Map<String, Object> oauth2Attributes) {
        Map<String, Object> account = (Map<String, Object>) oauth2Attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) account.get("profile");
        return OAuth2Attributes.builder().name((String) profile.get("nickname")).email((String) account.get("email")).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class OAuth2AttributesBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String email;

        @SuppressWarnings("all")
        
        OAuth2AttributesBuilder() {
        }

        @SuppressWarnings("all")
        
        public OAuth2Attributes.OAuth2AttributesBuilder name(@NonNull final String name) {
            if (name == null) {
                throw new NullPointerException("name is marked non-null but is null");
            }
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2Attributes.OAuth2AttributesBuilder email(@NonNull final String email) {
            if (email == null) {
                throw new NullPointerException("email is marked non-null but is null");
            }
            this.email = email;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2Attributes build() {
            return new OAuth2Attributes(this.name, this.email);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "OAuth2Attributes.OAuth2AttributesBuilder(name=" + this.name + ", email=" + this.email + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static OAuth2Attributes.OAuth2AttributesBuilder builder() {
        return new OAuth2Attributes.OAuth2AttributesBuilder();
    }

    @SuppressWarnings("all")
    
    public OAuth2Attributes(@NonNull final String name, @NonNull final String email) {
        if (name == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (email == null) {
            throw new NullPointerException("email is marked non-null but is null");
        }
        this.name = name;
        this.email = email;
    }

    @NonNull
    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @NonNull
    @SuppressWarnings("all")
    
    public String getEmail() {
        return this.email;
    }

    @SuppressWarnings("all")
    
    public void setName(@NonNull final String name) {
        if (name == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setEmail(@NonNull final String email) {
        if (email == null) {
            throw new NullPointerException("email is marked non-null but is null");
        }
        this.email = email;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OAuth2Attributes)) return false;
        final OAuth2Attributes other = (OAuth2Attributes) o;
        if (!other.canEqual((Object) this)) return false;
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
        return other instanceof OAuth2Attributes;
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
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "OAuth2Attributes(name=" + this.getName() + ", email=" + this.getEmail() + ")";
    }
    //</editor-fold>
}

@Service
public class OAuth2Service {
    private final OAuth2AuthorizedClientService authorizedClientService;

    private OAuth2AuthorizedClient getOAuth2Client() {
        OAuth2AuthenticationToken oauth2AuthToken = getOAuth2AuthToken();
        return authorizedClientService.loadAuthorizedClient(oauth2AuthToken.getAuthorizedClientRegistrationId(), oauth2AuthToken.getName());
    }

    private OAuth2User getOAuth2User() {
        return getOAuth2AuthToken().getPrincipal();
    }

    private OAuth2Attributes getOAuth2Attributes() {
        OAuth2User oauth2User = getOAuth2User();
        Map<String, Object> oauth2Attributes = oauth2User.getAttributes();
        switch (getProvider()) {
        case "github": 
            return OAuth2Attributes.ofGithub(oauth2Attributes);
        case "kakao": 
            return OAuth2Attributes.ofKakao(oauth2Attributes);
        default: 
            return null;
        }
    }

    public OAuth2AuthenticationToken getOAuth2AuthToken() {
        return (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }

    public String getProvider() {
        OAuth2AuthenticationToken oauth2AuthToken = getOAuth2AuthToken();
        return oauth2AuthToken.getAuthorizedClientRegistrationId();
    }

    public String getId() {
        OAuth2AuthenticationToken oauth2AuthToken = getOAuth2AuthToken();
        return oauth2AuthToken.getName();
    }

    public String getName() {
        OAuth2Attributes oauth2Attributes = getOAuth2Attributes();
        return oauth2Attributes.getName();
    }

    public String getEmail() {
        OAuth2Attributes oauth2Attributes = getOAuth2Attributes();
        return oauth2Attributes.getEmail();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public OAuth2Service(final OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }
    //</editor-fold>
}
