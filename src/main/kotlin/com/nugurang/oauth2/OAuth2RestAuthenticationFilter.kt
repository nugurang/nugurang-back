package com.nugurang.oauth2

import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.nugurang.dto.LoginRequestDto
import com.nugurang.http.MultiReadableHttpServletRequest
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.core.OAuth2AccessToken
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.OAuth2Error
import org.springframework.security.oauth2.core.OAuth2RefreshToken
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AndRequestMatcher
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.io.IOException
import java.time.Instant
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
//import org.springframework.security.authentication.BadCredentialsException;

class OAuth2RestAuthenticationFilter(
    private val objectMapper: ObjectMapper,
    private val clientRegistrationRepository: ClientRegistrationRepository,
    private val oauth2AuthorizedClientService: OAuth2AuthorizedClientService,
    filterProcessesUrl: String = DEFAULT_FILTER_PROCESSES_URL
) : AbstractAuthenticationProcessingFilter(
    AndRequestMatcher(
        AntPathRequestMatcher(filterProcessesUrl, HttpMethod.POST.name),
    )
) {
    //val jsonRequestMatcher = RequestHeaderRequestMatcher(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        // TODO: Improve duplicated code
        if (!requiresAuthentication(request as HttpServletRequest, response as HttpServletResponse)) {
            chain.doFilter(request, response)
            return
        }

        super.doFilter(MultiReadableHttpServletRequest(request), response, chain)
    }

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val loginRequestDto: LoginRequestDto = try {
            objectMapper.readValue(request.inputStream.readAllBytes(), LoginRequestDto::class.java)
        } catch (jme: JsonMappingException) {
            logger.error { jme.message }
            throw BadCredentialsException("Bad credentials", jme)
        }
        logger.info { loginRequestDto.accessToken.issuedAt.toString() }
        val registrationId = loginRequestDto.clientRegistrationId
        val clientRegistration = clientRegistrationRepository!!.findByRegistrationId(registrationId)
        if (clientRegistration == null) {
            val oauth2Error = OAuth2Error(
                CLIENT_REGISTRATION_NOT_FOUND_ERROR_CODE,
                "Client Registration not found with Id: $registrationId",
                null
            )
            throw OAuth2AuthenticationException(oauth2Error, oauth2Error.toString())
        }
        val oauth2AccessToken = OAuth2AccessToken(
            OAuth2AccessToken.TokenType.BEARER,
            loginRequestDto.accessToken.tokenValue,
            Instant.now(),
            Instant.MAX,
            loginRequestDto.accessToken.scopes
        )
        val oauth2RefreshToken =
            OAuth2RefreshToken(loginRequestDto.refreshToken.tokenValue, Instant.now(), Instant.MAX)
        val additionalParameters = loginRequestDto.additionalParameters
        val authenticationDetails = authenticationDetailsSource.buildDetails(request)
        val oauth2RestAuthenticationToken = authenticationManager.authenticate(
            OAuth2RestAuthenticationToken(
                clientRegistration,
                oauth2AccessToken,
                oauth2RefreshToken,
                additionalParameters
            )
        ) as OAuth2RestAuthenticationToken
        val oauth2AuthenticationToken = OAuth2AuthenticationToken(
            oauth2RestAuthenticationToken.principal,
            oauth2RestAuthenticationToken.authorities,
            oauth2RestAuthenticationToken.clientRegistration.registrationId
        )
        oauth2AuthenticationToken.details = authenticationDetails
        val oauth2AuthorizedClient = OAuth2AuthorizedClient(
            oauth2RestAuthenticationToken.clientRegistration,
            oauth2AuthenticationToken.name,
            oauth2RestAuthenticationToken.accessToken,
            oauth2RestAuthenticationToken.refreshToken
        )
        oauth2AuthorizedClientService.saveAuthorizedClient(oauth2AuthorizedClient, oauth2AuthenticationToken)
        return oauth2AuthenticationToken
    }

    companion object {
        private const val DEFAULT_FILTER_PROCESSES_URL = "/login"
        private const val CLIENT_REGISTRATION_NOT_FOUND_ERROR_CODE = "client_registration_not_found"
    }
}
