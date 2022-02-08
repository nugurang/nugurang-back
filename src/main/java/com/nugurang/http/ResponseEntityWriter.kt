package com.nugurang.http

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.http.HttpServletResponse

@Component
class ResponseEntityWriter(private val objectMapper: ObjectMapper) {
    @Throws(IOException::class)
    fun <T> write(responseEntity: ResponseEntity<T>, response: HttpServletResponse) {
        val servletServerHttpResponse = ServletServerHttpResponse(
            response
        )
        servletServerHttpResponse.setStatusCode(responseEntity.statusCode)
        servletServerHttpResponse.headers.putAll(responseEntity.headers)
        servletServerHttpResponse.body.write(objectMapper.writeValueAsBytes(responseEntity.body))
        servletServerHttpResponse.body.flush()
    }
}