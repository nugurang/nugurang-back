package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto
import com.nugurang.http.ResponseEntityWriter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class OAuth2RestAuthenticationEntryPoint(
    private val responseEntityWriter: ResponseEntityWriter,
) : AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        val responseDto = RestResponseDto(
            errors = listOf(
                RestResponseDto.Error(
                    message = authException.message ?: "No exception message",
                    extensions = RestResponseDto.Error.Extension(
                        type = authException.javaClass.simpleName
                    )
                )
            ),
        )
        val responseEntity = ResponseEntity(responseDto, HttpStatus.UNAUTHORIZED);
        responseEntityWriter.write(responseEntity, response);
    }
}