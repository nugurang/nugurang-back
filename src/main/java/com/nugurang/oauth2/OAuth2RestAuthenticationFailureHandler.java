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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class OAuth2RestAuthenticationFailureHandler implements AuthenticationFailureHandler {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OAuth2RestAuthenticationFailureHandler.class);
    //</editor-fold>
    private final ResponseEntityWriter responseEntityWriter;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("AuthenticationFailureHandler");
        final var responseDto = RestResponseDto.builder().data(Optional.empty()).errors(Optional.of(List.of(RestResponseDto.Error.builder().message(exception.getMessage()).extensions(Optional.of(RestResponseDto.Error.ErrorExtension.builder().type(exception.getClass().getSimpleName()).build())).build()))).build();
        final var responseEntity = new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);
        responseEntityWriter.write(responseEntity, response);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public OAuth2RestAuthenticationFailureHandler(final ResponseEntityWriter responseEntityWriter) {
        this.responseEntityWriter = responseEntityWriter;
    }
    //</editor-fold>
}
