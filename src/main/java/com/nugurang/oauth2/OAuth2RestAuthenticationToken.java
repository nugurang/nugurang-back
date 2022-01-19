package com.nugurang.oauth2;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

class OAuth2RestAuthenticationToken extends AbstractAuthenticationToken {
    private ClientRegistration clientRegistration;
    private OAuth2AccessToken accessToken;
    private OAuth2RefreshToken refreshToken;
    private Map<String, Object> additionalParameters;
    private OAuth2User principal;

    public OAuth2RestAuthenticationToken(Collection<? extends GrantedAuthority> authorities, ClientRegistration clientRegistration, OAuth2AccessToken accessToken, OAuth2RefreshToken refreshToken, Map<String, Object> additionalParameters, OAuth2User principal) {
        super(authorities);
        this.clientRegistration = clientRegistration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.additionalParameters = additionalParameters;
        this.principal = principal;
        this.setAuthenticated(true);
    }

    public OAuth2RestAuthenticationToken(ClientRegistration clientRegistration, OAuth2AccessToken accessToken, OAuth2RefreshToken refreshToken, Map<String, Object> additionalParameters) {
        this(Collections.emptyList(), clientRegistration, accessToken, refreshToken, additionalParameters, null);
        this.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public OAuth2User getPrincipal() {
        return this.principal;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class OAuth2RestAuthenticationTokenBuilder {
        @SuppressWarnings("all")
        
        private Collection<? extends GrantedAuthority> authorities;
        @SuppressWarnings("all")
        
        private ClientRegistration clientRegistration;
        @SuppressWarnings("all")
        
        private OAuth2AccessToken accessToken;
        @SuppressWarnings("all")
        
        private OAuth2RefreshToken refreshToken;
        @SuppressWarnings("all")
        
        private Map<String, Object> additionalParameters;
        @SuppressWarnings("all")
        
        private OAuth2User principal;

        @SuppressWarnings("all")
        
        OAuth2RestAuthenticationTokenBuilder() {
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder authorities(final Collection<? extends GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder clientRegistration(final ClientRegistration clientRegistration) {
            this.clientRegistration = clientRegistration;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder accessToken(final OAuth2AccessToken accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder refreshToken(final OAuth2RefreshToken refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder additionalParameters(final Map<String, Object> additionalParameters) {
            this.additionalParameters = additionalParameters;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder principal(final OAuth2User principal) {
            this.principal = principal;
            return this;
        }

        @SuppressWarnings("all")
        
        public OAuth2RestAuthenticationToken build() {
            return new OAuth2RestAuthenticationToken(this.authorities, this.clientRegistration, this.accessToken, this.refreshToken, this.additionalParameters, this.principal);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder(authorities=" + this.authorities + ", clientRegistration=" + this.clientRegistration + ", accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ", additionalParameters=" + this.additionalParameters + ", principal=" + this.principal + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder builder() {
        return new OAuth2RestAuthenticationToken.OAuth2RestAuthenticationTokenBuilder();
    }

    @SuppressWarnings("all")
    
    public ClientRegistration getClientRegistration() {
        return this.clientRegistration;
    }

    @SuppressWarnings("all")
    
    public OAuth2AccessToken getAccessToken() {
        return this.accessToken;
    }

    @SuppressWarnings("all")
    
    public OAuth2RefreshToken getRefreshToken() {
        return this.refreshToken;
    }

    @SuppressWarnings("all")
    
    public Map<String, Object> getAdditionalParameters() {
        return this.additionalParameters;
    }

    @SuppressWarnings("all")
    
    public void setClientRegistration(final ClientRegistration clientRegistration) {
        this.clientRegistration = clientRegistration;
    }

    @SuppressWarnings("all")
    
    public void setAccessToken(final OAuth2AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @SuppressWarnings("all")
    
    public void setRefreshToken(final OAuth2RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    @SuppressWarnings("all")
    
    public void setAdditionalParameters(final Map<String, Object> additionalParameters) {
        this.additionalParameters = additionalParameters;
    }

    @SuppressWarnings("all")
    
    public void setPrincipal(final OAuth2User principal) {
        this.principal = principal;
    }
    //</editor-fold>
}
