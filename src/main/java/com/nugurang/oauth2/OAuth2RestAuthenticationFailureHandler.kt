package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto
import com.nugurang.http.ResponseEntityWriter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class OAuth2RestAuthenticationFailureHandler(
    private val responseEntityWriter: ResponseEntityWriter
) : AuthenticationFailureHandler {

    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        val responseDto = RestResponseDto(
            errors = listOf(
                RestResponseDto.Error(
                    message = exception!!.message!!,
                    extensions = RestResponseDto.Error.Extension(
                        type = exception.javaClass.simpleName
                    )
                )
            ),
        )
        val responseEntity = ResponseEntity(responseDto, HttpStatus.UNAUTHORIZED)
        responseEntityWriter.write(responseEntity, response)
    }
}