package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto
import com.nugurang.http.ResponseEntityWriter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class OAuth2RestAccessDeniedHandler(
    private val responseEntityWriter: ResponseEntityWriter
) : AccessDeniedHandler {

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {
        val responseDto = RestResponseDto(
            errors = listOf(
                RestResponseDto.Error(
                    message = accessDeniedException!!.message!!,
                    extensions = RestResponseDto.Error.Extension(
                        type = accessDeniedException.javaClass.simpleName
                    )
                )
            ),
        )
        val responseEntity = ResponseEntity(responseDto, HttpStatus.FORBIDDEN);
        responseEntityWriter.write(responseEntity, response);
    }
}