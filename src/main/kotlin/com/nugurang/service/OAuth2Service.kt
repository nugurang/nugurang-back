package com.nugurang.service

import com.nugurang.exception.NotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

internal data class OAuth2Attributes(val name: String, val email: String) {
    companion object {
        fun ofGithub(oauth2Attributes: Map<String, Any>): OAuth2Attributes {
            return OAuth2Attributes(
                name = oauth2Attributes["login"] as String,
                email = oauth2Attributes["email"] as String
            )
        }

        fun ofKakao(oauth2Attributes: Map<String, Any>): OAuth2Attributes {
            val account = oauth2Attributes["kakao_account"] as Map<String, Any>
            val profile = account["profile"] as Map<String, Any>
            return OAuth2Attributes(
                name = profile["nickname"] as String,
                email = account["email"] as String
            )
        }
    }
}

@Service
class OAuth2Service(private val authorizedClientService: OAuth2AuthorizedClientService) {

    private fun getOAuth2Client(): OAuth2AuthorizedClient {
        val oauth2AuthToken = getOAuth2AuthToken()
        return authorizedClientService.loadAuthorizedClient(
            oauth2AuthToken.authorizedClientRegistrationId,
            oauth2AuthToken.name
        )
    }

    private fun getOAuth2User(): OAuth2User {
        return getOAuth2AuthToken().principal
    }

    private fun getOAuth2Attributes(): OAuth2Attributes {
        val oauth2User = getOAuth2User()
        val oauth2Attributes = oauth2User.attributes
        return when (getProvider()) {
            "github" -> OAuth2Attributes.ofGithub(oauth2Attributes)
            "kakao" -> OAuth2Attributes.ofKakao(oauth2Attributes)
            else -> throw NotFoundException(OAuth2Attributes::class.java)
        }
    }

    fun getOAuth2AuthToken(): OAuth2AuthenticationToken {
        return SecurityContextHolder.getContext().authentication as OAuth2AuthenticationToken
    }

    fun getProvider(): String {
        val oauth2AuthToken = getOAuth2AuthToken()
        return oauth2AuthToken.authorizedClientRegistrationId
    }

    fun getId(): String  {
        val oauth2AuthToken = getOAuth2AuthToken()
        return oauth2AuthToken.name
    }

    fun getName(): String {
        val oauth2Attributes = getOAuth2Attributes()
        return oauth2Attributes.name
    }

    fun getEmail(): String {
        val oauth2Attributes = getOAuth2Attributes()
        return oauth2Attributes.email
    }
}