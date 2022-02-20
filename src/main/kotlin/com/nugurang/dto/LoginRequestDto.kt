package com.nugurang.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

class LoginRequestDto @JsonCreator constructor(
    @param:JsonProperty(required = true) val clientRegistrationId: String,
    @param:JsonProperty(required = true) val accessToken: AccessToken,
    @param:JsonProperty(required = true) val refreshToken: RefreshToken,
    @param:JsonProperty(required = true) val additionalParameters: Map<String, Any>
) {
    data class AccessToken @JsonCreator constructor(
        @param:JsonProperty(required = true) val tokenValue: String,
        @param:JsonProperty(required = true) val issuedAt: Instant,
        @param:JsonProperty(required = true) val expiresAt: Instant?,
        @param:JsonProperty(required = true) val scopes: Set<String>
    )

    data class RefreshToken @JsonCreator constructor(
        @param:JsonProperty(required = true) val tokenValue: String,
        @param:JsonProperty(required = true) val issuedAt: Instant,
        @param:JsonProperty(required = true) val expiresAt: Instant?
    )
}