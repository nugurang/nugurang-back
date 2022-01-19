package com.nugurang.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Map;
import java.util.Set;

public class SigninRequestDto {

    public static class AccessToken {
        private String tokenValue;
        private Instant issuedAt;
        private Instant expiresAt;
        private Set<String> scopes;

        @JsonCreator
        public AccessToken(@JsonProperty(required = true) String tokenValue, @JsonProperty(required = true) Instant issuedAt, @JsonProperty(required = true) Instant expiresAt, @JsonProperty(required = true) Set<String> scopes) {
            this.tokenValue = tokenValue;
            this.issuedAt = issuedAt;
            this.expiresAt = expiresAt;
            this.scopes = scopes;
        }


        @SuppressWarnings("all")
        public static class AccessTokenBuilder {
            @SuppressWarnings("all")
            private String tokenValue;
            @SuppressWarnings("all")
            private Instant issuedAt;
            @SuppressWarnings("all")
            private Instant expiresAt;
            @SuppressWarnings("all")
            private Set<String> scopes;

            @SuppressWarnings("all")
            AccessTokenBuilder() {
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.AccessToken.AccessTokenBuilder tokenValue(final String tokenValue) {
                this.tokenValue = tokenValue;
                return this;
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.AccessToken.AccessTokenBuilder issuedAt(final Instant issuedAt) {
                this.issuedAt = issuedAt;
                return this;
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.AccessToken.AccessTokenBuilder expiresAt(final Instant expiresAt) {
                this.expiresAt = expiresAt;
                return this;
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.AccessToken.AccessTokenBuilder scopes(final Set<String> scopes) {
                this.scopes = scopes;
                return this;
            }

            @SuppressWarnings("all")
            public SigninRequestDto.AccessToken build() {
                return new SigninRequestDto.AccessToken(this.tokenValue, this.issuedAt, this.expiresAt, this.scopes);
            }

            @Override
            @SuppressWarnings("all")
            public String toString() {
                return "SigninRequestDto.AccessToken.AccessTokenBuilder(tokenValue=" + this.tokenValue + ", issuedAt=" + this.issuedAt + ", expiresAt=" + this.expiresAt + ", scopes=" + this.scopes + ")";
            }
        }

        @SuppressWarnings("all")
        public static SigninRequestDto.AccessToken.AccessTokenBuilder builder() {
            return new SigninRequestDto.AccessToken.AccessTokenBuilder();
        }

        @SuppressWarnings("all")
        public String getTokenValue() {
            return this.tokenValue;
        }

        @SuppressWarnings("all")
        public Instant getIssuedAt() {
            return this.issuedAt;
        }

        @SuppressWarnings("all")
        public Instant getExpiresAt() {
            return this.expiresAt;
        }

        @SuppressWarnings("all")
        public Set<String> getScopes() {
            return this.scopes;
        }

        @SuppressWarnings("all")
        public void setTokenValue(final String tokenValue) {
            this.tokenValue = tokenValue;
        //<editor-fold defaultstate="collapsed" desc="delombok">
        }

        @SuppressWarnings("all")
        public void setIssuedAt(final Instant issuedAt) {
        //</editor-fold>
            this.issuedAt = issuedAt;
        //<editor-fold defaultstate="collapsed" desc="delombok">
        }

        @SuppressWarnings("all")
        public void setExpiresAt(final Instant expiresAt) {
        //</editor-fold>
            this.expiresAt = expiresAt;
        //<editor-fold defaultstate="collapsed" desc="delombok">
        }

        @SuppressWarnings("all")
        public void setScopes(final Set<String> scopes) {
        //</editor-fold>
            this.scopes = scopes;
        }

        //<editor-fold defaultstate="collapsed" desc="delombok">
        @Override
        @SuppressWarnings("all")
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof SigninRequestDto.AccessToken)) return false;
            final SigninRequestDto.AccessToken other = (SigninRequestDto.AccessToken) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$tokenValue = this.getTokenValue();
            final Object other$tokenValue = other.getTokenValue();
            if (this$tokenValue == null ? other$tokenValue != null : !this$tokenValue.equals(other$tokenValue)) return false;
            final Object this$issuedAt = this.getIssuedAt();
            final Object other$issuedAt = other.getIssuedAt();
            if (this$issuedAt == null ? other$issuedAt != null : !this$issuedAt.equals(other$issuedAt)) return false;
            final Object this$expiresAt = this.getExpiresAt();
            final Object other$expiresAt = other.getExpiresAt();
            if (this$expiresAt == null ? other$expiresAt != null : !this$expiresAt.equals(other$expiresAt)) return false;
            final Object this$scopes = this.getScopes();
            final Object other$scopes = other.getScopes();
            if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) return false;
            return true;
        }

        @SuppressWarnings("all")
        protected boolean canEqual(final Object other) {
            return other instanceof SigninRequestDto.AccessToken;
        }

        @Override
        @SuppressWarnings("all")
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $tokenValue = this.getTokenValue();
            result = result * PRIME + ($tokenValue == null ? 43 : $tokenValue.hashCode());
            final Object $issuedAt = this.getIssuedAt();
            result = result * PRIME + ($issuedAt == null ? 43 : $issuedAt.hashCode());
            final Object $expiresAt = this.getExpiresAt();
            result = result * PRIME + ($expiresAt == null ? 43 : $expiresAt.hashCode());
            final Object $scopes = this.getScopes();
            result = result * PRIME + ($scopes == null ? 43 : $scopes.hashCode());
            return result;
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "SigninRequestDto.AccessToken(tokenValue=" + this.getTokenValue() + ", issuedAt=" + this.getIssuedAt() + ", expiresAt=" + this.getExpiresAt() + ", scopes=" + this.getScopes() + ")";
        }
        //</editor-fold>
    }


    public static class RefreshToken {
        private String tokenValue;
        private Instant issuedAt;
        private Instant expiresAt;

        @JsonCreator
        public RefreshToken(@JsonProperty(required = true) String tokenValue, @JsonProperty(required = true) Instant issuedAt, @JsonProperty(required = true) Instant expiresAt) {
            this.tokenValue = tokenValue;
            this.issuedAt = issuedAt;
            this.expiresAt = expiresAt;
        }


        @SuppressWarnings("all")
        public static class RefreshTokenBuilder {
            @SuppressWarnings("all")
            private String tokenValue;
            @SuppressWarnings("all")
            private Instant issuedAt;
            @SuppressWarnings("all")
            private Instant expiresAt;

            @SuppressWarnings("all")
            RefreshTokenBuilder() {
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.RefreshToken.RefreshTokenBuilder tokenValue(final String tokenValue) {
                this.tokenValue = tokenValue;
                return this;
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.RefreshToken.RefreshTokenBuilder issuedAt(final Instant issuedAt) {
                this.issuedAt = issuedAt;
                return this;
            }

            @JsonProperty(required = true)
            @SuppressWarnings("all")
            public SigninRequestDto.RefreshToken.RefreshTokenBuilder expiresAt(final Instant expiresAt) {
                this.expiresAt = expiresAt;
                return this;
            }

            @SuppressWarnings("all")
            public SigninRequestDto.RefreshToken build() {
                return new SigninRequestDto.RefreshToken(this.tokenValue, this.issuedAt, this.expiresAt);
            }

            @Override
            @SuppressWarnings("all")
            public String toString() {
                return "SigninRequestDto.RefreshToken.RefreshTokenBuilder(tokenValue=" + this.tokenValue + ", issuedAt=" + this.issuedAt + ", expiresAt=" + this.expiresAt + ")";
            }
        }

        @SuppressWarnings("all")
        public static SigninRequestDto.RefreshToken.RefreshTokenBuilder builder() {
            return new SigninRequestDto.RefreshToken.RefreshTokenBuilder();
        }

        @SuppressWarnings("all")
        public String getTokenValue() {
            return this.tokenValue;
        }

        @SuppressWarnings("all")
        public Instant getIssuedAt() {
            return this.issuedAt;
        }

        @SuppressWarnings("all")
        public Instant getExpiresAt() {
            return this.expiresAt;
        }

        @SuppressWarnings("all")
        public void setTokenValue(final String tokenValue) {
            this.tokenValue = tokenValue;
        //<editor-fold defaultstate="collapsed" desc="delombok">
        }

        @SuppressWarnings("all")
        public void setIssuedAt(final Instant issuedAt) {
        //</editor-fold>
            this.issuedAt = issuedAt;
        //<editor-fold defaultstate="collapsed" desc="delombok">
        }

        @SuppressWarnings("all")
        public void setExpiresAt(final Instant expiresAt) {
        //</editor-fold>
            this.expiresAt = expiresAt;
        }

        //<editor-fold defaultstate="collapsed" desc="delombok">
        @Override
        @SuppressWarnings("all")
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof SigninRequestDto.RefreshToken)) return false;
            final SigninRequestDto.RefreshToken other = (SigninRequestDto.RefreshToken) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$tokenValue = this.getTokenValue();
            final Object other$tokenValue = other.getTokenValue();
            if (this$tokenValue == null ? other$tokenValue != null : !this$tokenValue.equals(other$tokenValue)) return false;
            final Object this$issuedAt = this.getIssuedAt();
            final Object other$issuedAt = other.getIssuedAt();
            if (this$issuedAt == null ? other$issuedAt != null : !this$issuedAt.equals(other$issuedAt)) return false;
            final Object this$expiresAt = this.getExpiresAt();
            final Object other$expiresAt = other.getExpiresAt();
            if (this$expiresAt == null ? other$expiresAt != null : !this$expiresAt.equals(other$expiresAt)) return false;
            return true;
        }

        @SuppressWarnings("all")
        protected boolean canEqual(final Object other) {
            return other instanceof SigninRequestDto.RefreshToken;
        }

        @Override
        @SuppressWarnings("all")
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $tokenValue = this.getTokenValue();
            result = result * PRIME + ($tokenValue == null ? 43 : $tokenValue.hashCode());
            final Object $issuedAt = this.getIssuedAt();
            result = result * PRIME + ($issuedAt == null ? 43 : $issuedAt.hashCode());
            final Object $expiresAt = this.getExpiresAt();
            result = result * PRIME + ($expiresAt == null ? 43 : $expiresAt.hashCode());
            return result;
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "SigninRequestDto.RefreshToken(tokenValue=" + this.getTokenValue() + ", issuedAt=" + this.getIssuedAt() + ", expiresAt=" + this.getExpiresAt() + ")";
        }
        //</editor-fold>
    }

    private String clientRegistrationId;
    private AccessToken accessToken;
    private RefreshToken refreshToken;
    private Map<String, Object> additionalParameters;

    @JsonCreator
    public SigninRequestDto(@JsonProperty(required = true) String clientRegistrationId, @JsonProperty(required = true) AccessToken accessToken, @JsonProperty(required = true) RefreshToken refreshToken, @JsonProperty(required = true) Map<String, Object> additionalParameters) {
        this.clientRegistrationId = clientRegistrationId;
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.additionalParameters = additionalParameters;
    }


    @SuppressWarnings("all")
    public static class SigninRequestDtoBuilder {
        @SuppressWarnings("all")
        private String clientRegistrationId;
        @SuppressWarnings("all")
        private AccessToken accessToken;
        @SuppressWarnings("all")
        private RefreshToken refreshToken;
        @SuppressWarnings("all")
        private Map<String, Object> additionalParameters;

        @SuppressWarnings("all")
        SigninRequestDtoBuilder() {
        }

        @JsonProperty(required = true)
        @SuppressWarnings("all")
        public SigninRequestDto.SigninRequestDtoBuilder clientRegistrationId(final String clientRegistrationId) {
            this.clientRegistrationId = clientRegistrationId;
            return this;
        }

        @JsonProperty(required = true)
        @SuppressWarnings("all")
        public SigninRequestDto.SigninRequestDtoBuilder accessToken(final AccessToken accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @JsonProperty(required = true)
        @SuppressWarnings("all")
        public SigninRequestDto.SigninRequestDtoBuilder refreshToken(final RefreshToken refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        @JsonProperty(required = true)
        @SuppressWarnings("all")
        public SigninRequestDto.SigninRequestDtoBuilder additionalParameters(final Map<String, Object> additionalParameters) {
            this.additionalParameters = additionalParameters;
            return this;
        }

        @SuppressWarnings("all")
        public SigninRequestDto build() {
            return new SigninRequestDto(this.clientRegistrationId, this.accessToken, this.refreshToken, this.additionalParameters);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "SigninRequestDto.SigninRequestDtoBuilder(clientRegistrationId=" + this.clientRegistrationId + ", accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ", additionalParameters=" + this.additionalParameters + ")";
        }
    }

    @SuppressWarnings("all")
    public static SigninRequestDto.SigninRequestDtoBuilder builder() {
        return new SigninRequestDto.SigninRequestDtoBuilder();
    }

    @SuppressWarnings("all")
    public String getClientRegistrationId() {
        return this.clientRegistrationId;
    }

    @SuppressWarnings("all")
    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    @SuppressWarnings("all")
    public RefreshToken getRefreshToken() {
        return this.refreshToken;
    }

    @SuppressWarnings("all")
    public Map<String, Object> getAdditionalParameters() {
        return this.additionalParameters;
    }

    @SuppressWarnings("all")
    public void setClientRegistrationId(final String clientRegistrationId) {
        this.clientRegistrationId = clientRegistrationId;
    }

    @SuppressWarnings("all")
    public void setAccessToken(final AccessToken accessToken) {
        this.accessToken = accessToken;
    //<editor-fold defaultstate="collapsed" desc="delombok">
    }

    @SuppressWarnings("all")
    public void setRefreshToken(final RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    @SuppressWarnings("all")
    public void setAdditionalParameters(final Map<String, Object> additionalParameters) {
    //</editor-fold>
        this.additionalParameters = additionalParameters;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SigninRequestDto)) return false;
        final SigninRequestDto other = (SigninRequestDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$clientRegistrationId = this.getClientRegistrationId();
        final Object other$clientRegistrationId = other.getClientRegistrationId();
        if (this$clientRegistrationId == null ? other$clientRegistrationId != null : !this$clientRegistrationId.equals(other$clientRegistrationId)) return false;
        final Object this$accessToken = this.getAccessToken();
        final Object other$accessToken = other.getAccessToken();
        if (this$accessToken == null ? other$accessToken != null : !this$accessToken.equals(other$accessToken)) return false;
        final Object this$refreshToken = this.getRefreshToken();
        final Object other$refreshToken = other.getRefreshToken();
        if (this$refreshToken == null ? other$refreshToken != null : !this$refreshToken.equals(other$refreshToken)) return false;
        final Object this$additionalParameters = this.getAdditionalParameters();
        final Object other$additionalParameters = other.getAdditionalParameters();
        if (this$additionalParameters == null ? other$additionalParameters != null : !this$additionalParameters.equals(other$additionalParameters)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof SigninRequestDto;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $clientRegistrationId = this.getClientRegistrationId();
        result = result * PRIME + ($clientRegistrationId == null ? 43 : $clientRegistrationId.hashCode());
        final Object $accessToken = this.getAccessToken();
        result = result * PRIME + ($accessToken == null ? 43 : $accessToken.hashCode());
        final Object $refreshToken = this.getRefreshToken();
        result = result * PRIME + ($refreshToken == null ? 43 : $refreshToken.hashCode());
        final Object $additionalParameters = this.getAdditionalParameters();
        result = result * PRIME + ($additionalParameters == null ? 43 : $additionalParameters.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "SigninRequestDto(clientRegistrationId=" + this.getClientRegistrationId() + ", accessToken=" + this.getAccessToken() + ", refreshToken=" + this.getRefreshToken() + ", additionalParameters=" + this.getAdditionalParameters() + ")";
    }
    //</editor-fold>
}
