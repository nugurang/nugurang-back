package com.nugurang.oauth2

import com.nugurang.oauth2.OAuth2RestAuthenticationToken
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User

class OAuth2RestAuthenticationProvider : AuthenticationProvider {
    private val oauth2UserService: OAuth2UserService<OAuth2UserRequest, OAuth2User> = DefaultOAuth2UserService()
    private val authoritiesMapper =
        GrantedAuthoritiesMapper { authorities: Collection<GrantedAuthority?>? -> authorities }

    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val oauth2RestAuthenticationToken = authentication as OAuth2RestAuthenticationToken
        val oauth2User = oauth2UserService.loadUser(
            OAuth2UserRequest(
                oauth2RestAuthenticationToken.clientRegistration,
                oauth2RestAuthenticationToken.accessToken,
                oauth2RestAuthenticationToken.additionalParameters
            )
        )
        return OAuth2RestAuthenticationToken(
            authoritiesMapper.mapAuthorities(oauth2User.authorities),
            oauth2RestAuthenticationToken.clientRegistration,
            oauth2RestAuthenticationToken.accessToken,
            oauth2RestAuthenticationToken.refreshToken,
            oauth2RestAuthenticationToken.additionalParameters,
            oauth2User
        )
    }

    override fun supports(authentication: Class<*>): Boolean {
        return OAuth2RestAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}