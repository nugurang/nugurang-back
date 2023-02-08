package com.nugurang.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.nugurang.oauth2.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.web.authentication.logout.LogoutFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val oauth2RestAuthenticationEntryPoint: OAuth2RestAuthenticationEntryPoint,
    private val oauth2RestAuthenticationSuccessHandler: OAuth2RestAuthenticationSuccessHandler,
    private val oauth2RestAuthenticationFailureHandler: OAuth2RestAuthenticationFailureHandler,
    private val oauth2RestAccessDeniedHandler: OAuth2RestAccessDeniedHandler,
    private val objectMapper: ObjectMapper,
    private val clientRegistrationRepository: ClientRegistrationRepository,
    private val oauth2AuthorizedClientService: OAuth2AuthorizedClientService,
    @Value("\${nugurang.addr.front.url}")
    private val frontUrl: String
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .cors()
            .and()
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/login", "/test")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(oauth2RestAuthenticationEntryPoint)
            .accessDeniedHandler(oauth2RestAccessDeniedHandler)
            .and()
            .oauth2Login()
            /*
            .userInfoEndpoint()
            .userService(DefaultOAuth2UserService())
            */
            .and()
            .logout()
            .permitAll()
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .and()
            .headers()
            .frameOptions()
            .sameOrigin()
            .and()
            .addFilterBefore(createOauth2AuthenticationFilter(), LogoutFilter::class.java)
        /*.securityContext()
            .securityContextRepository(new NullSecurityContextRepository())*/
        /* TODO
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        */
    }

    fun createOauth2AuthenticationFilter(): OAuth2RestAuthenticationFilter {
        val filter = OAuth2RestAuthenticationFilter(
            objectMapper,
            clientRegistrationRepository,
            oauth2AuthorizedClientService
        )

        filter.setAuthenticationManager(
            ProviderManager(
                listOf(OAuth2RestAuthenticationProvider())
            )
        )
        filter.setAuthenticationSuccessHandler(oauth2RestAuthenticationSuccessHandler)
        filter.setAuthenticationFailureHandler(oauth2RestAuthenticationFailureHandler)
        return filter
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.addAllowedOrigin(frontUrl)
        configuration.addAllowedHeader("*")
        configuration.addAllowedMethod("*")
        configuration.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
    /*
    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return new DefaultOAuth2UserService();
    }
 */
}
