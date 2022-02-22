package com.nugurang.rest.controller

import org.springframework.security.authentication.AuthenticationDetailsSource
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class HomeController(
    private val authorizedClientService: OAuth2AuthorizedClientService,
    private val clientRegistrationRepository: ClientRegistrationRepository
) {
    private val userService: OAuth2UserService<OAuth2UserRequest, OAuth2User> = DefaultOAuth2UserService()
    private val authenticationDetailsSource: AuthenticationDetailsSource<HttpServletRequest, *> =
        WebAuthenticationDetailsSource()

    @RequestMapping("/")
    fun index(): String {
        val auth = SecurityContextHolder.getContext().authentication
        val principal = auth.principal
        val oauth2 = auth as OAuth2AuthenticationToken
        val client = authorizedClientService.loadAuthorizedClient<OAuth2AuthorizedClient>(
            oauth2.authorizedClientRegistrationId,
            oauth2.name
        )
        val oauth2User = oauth2.principal
        val attributes = oauth2User.attributes
        for ((key) in attributes) {
            println(key)
        }
        val name = attributes["login"].toString()
        val email = attributes["email"].toString()
        /*
        String name = (String) (
            (Map) (
                (Map) oauth2User
                .getAttribute("kakao_account")
            )
            .get("profile")
        ).get("nickname");
        */
        /*
        if (client == null) {
            return "authorized client is null "
                + oauth2.getAuthorizedClientRegistrationId()
                + " " + oauth2.getName() + " " + name;
        }
        OAuth2AccessToken accessToken = client.getAccessToken();
        return client.getPrincipalName()
            + " " + accessToken
            + " " + oauth2.getAuthorizedClientRegistrationId()
            + " " + authentication.getName() + " " + name + " " + email;
        */return java.lang.String.join(
            "<br/>",
            oauth2.authorizedClientRegistrationId,
            oauth2.name,
            name,
            email,
            principal.toString(),
            (principal is UserDetails).toString(),
            (principal is OAuth2User).toString(),
            if (auth.getDetails() != null) auth.getDetails().toString() else "null",
            if (client != null) client.accessToken.tokenValue else "null",
            client?.accessToken?.issuedAt?.toString() ?: "null",
            client?.accessToken?.expiresAt?.toString() ?: "null"
        )
    }
}