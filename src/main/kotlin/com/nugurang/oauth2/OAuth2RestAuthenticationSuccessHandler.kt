package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto
import com.nugurang.http.ResponseEntityWriter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class OAuth2RestAuthenticationSuccessHandler(
    private val responseEntityWriter: ResponseEntityWriter
) : AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val responseDto = RestResponseDto(data = authentication)
        val responseEntity = ResponseEntity(responseDto, HttpStatus.OK)
        responseEntityWriter.write(responseEntity, response)
    }
}