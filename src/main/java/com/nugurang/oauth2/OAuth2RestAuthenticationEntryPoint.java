package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto;
import com.nugurang.http.ResponseEntityWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class OAuth2RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @SuppressWarnings("all")
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OAuth2RestAuthenticationEntryPoint.class);
    private final ResponseEntityWriter responseEntityWriter;

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("AuthenticationEntryPoint");
        final var responseDto = RestResponseDto.builder().data(Optional.empty()).errors(Optional.of(List.of(RestResponseDto.Error.builder().message(authException.getMessage()).extensions(Optional.of(RestResponseDto.Error.ErrorExtension.builder().type(authException.getClass().getSimpleName()).build())).build()))).build();
        //ResponseDto.fromException?
        final var responseEntity = new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);
        responseEntityWriter.write(responseEntity, response);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public OAuth2RestAuthenticationEntryPoint(final ResponseEntityWriter responseEntityWriter) {
        this.responseEntityWriter = responseEntityWriter;
    }
    //</editor-fold>
}
