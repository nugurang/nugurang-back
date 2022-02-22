package com.nugurang.oauth2

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.core.OAuth2AccessToken
import org.springframework.security.oauth2.core.OAuth2RefreshToken
import org.springframework.security.oauth2.core.user.OAuth2User

internal class OAuth2RestAuthenticationToken(
    authorities: Collection<GrantedAuthority>?,
    var clientRegistration: ClientRegistration,
    var accessToken: OAuth2AccessToken,
    var refreshToken: OAuth2RefreshToken?,
    var additionalParameters: Map<String, Any>?,
    private var principal: OAuth2User?
) : AbstractAuthenticationToken(authorities) {
    init {
        this.isAuthenticated = true
    }

    constructor(
        clientRegistration: ClientRegistration,
        accessToken: OAuth2AccessToken,
        refreshToken: OAuth2RefreshToken?,
        additionalParameters: Map<String, Any>?
    ) : this(emptyList<GrantedAuthority>(), clientRegistration, accessToken, refreshToken, additionalParameters, null) {
        this.isAuthenticated = false
    }

    override fun getCredentials(): Any {
        return ""
    }

    override fun getPrincipal(): OAuth2User? {
        return principal
    }

    fun setPrincipal(principal: OAuth2User) {
        this.principal = principal
    }
}