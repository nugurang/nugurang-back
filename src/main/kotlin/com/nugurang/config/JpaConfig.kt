package com.nugurang.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ActiveProfiles
import java.time.OffsetDateTime
import java.util.*

@Configuration
@EntityScan("com.nugurang.entity")
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
@EnableJpaRepositories("com.nugurang.dao")
@Import(QueryDslConfig::class)
class JpaConfig {
    @Bean
    fun auditingDateTimeProvider(): DateTimeProvider {
        return DateTimeProvider { Optional.of(OffsetDateTime.now()) }
    }
}