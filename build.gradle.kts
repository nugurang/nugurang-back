import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val checkstyleVersion = "9.2.1"
val pmdVersion = "6.+"

group = "com.nugurang"
version = "0.0.1-SNAPSHOT"

plugins {
    java
    `java-library`
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("io.freefair.lombok") version "6.1.0"
    id("org.springframework.boot") version "2.6.2"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

java {
    sourceCompatibility = JavaVersion.VERSION_14
    targetCompatibility = JavaVersion.VERSION_14
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    arrayOf(
        "com.querydsl:querydsl-jpa"
    ).map(::api)

    arrayOf(
        "com.querydsl:querydsl-apt::jpa",
        "javax.persistence:javax.persistence-api",
        "javax.annotation:javax.annotation-api",
        "org.mapstruct:mapstruct-processor:1.4.2.Final",
        "org.projectlombok:lombok",
        "org.projectlombok:lombok-mapstruct-binding:0.2.0",
        "org.springframework.boot:spring-boot-configuration-processor"
    ).map(::annotationProcessor)

    arrayOf(
        "com.google.guava:guava:31.0.1-jre",
        "com.graphql-java-kickstart:graphql-spring-boot-starter:12.+",
        "com.graphql-java-kickstart:voyager-spring-boot-starter:11.1.0",
        "com.graphql-java:graphql-java-extended-scalars:17.0",
        "com.graphql-java:graphql-java-spring-boot-starter-webmvc:2.0",
        "com.vladmihalcea:hibernate-types-52:2.14.0",
        "javax.cache:cache-api",
        "org.ehcache:ehcache",
        "org.mapstruct:mapstruct:1.4.2.Final",
        "org.springframework.boot:spring-boot-starter-actuator",
        "org.springframework.boot:spring-boot-starter-batch",
        "org.springframework.boot:spring-boot-starter-cache",
        "org.springframework.boot:spring-boot-starter-data-jpa",
        "org.springframework.boot:spring-boot-starter-oauth2-client",
        "org.springframework.boot:spring-boot-starter-security",
        "org.springframework.boot:spring-boot-starter-validation",
        "org.springframework.boot:spring-boot-starter-web",
        "org.springframework.security:spring-security-acl",
        "net.time4j:time4j-base:5.8",
        "net.time4j:time4j-sqlxml:5.8",
        "net.time4j:time4j-tzdata:5.0-2020a",
        "net.sf.ehcache:ehcache-core:2.6.11",
        "org.jetbrains.kotlin:kotlin-reflect",
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8",
        "org.springframework.boot:spring-boot-starter-test"
    ).map(::implementation)

    arrayOf(
        "org.projectlombok:lombok"
    ).map(::compileOnly)

    arrayOf(
        "org.springframework.boot:spring-boot-devtools"
    ).map(::developmentOnly)

    arrayOf(
        "com.graphql-java-kickstart:graphiql-spring-boot-starter:11.1.0",
        "com.h2database:h2",
        "mysql:mysql-connector-java"
    ).map(::runtimeOnly)

    arrayOf(
        "com.graphql-java-kickstart:graphql-spring-boot-starter-test:12.+",
        "org.springframework.batch:spring-batch-test",
        "org.springframework.security:spring-security-test"
    ).map(::testImplementation)

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "14"
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(arrayOf("-Xlint:deprecation", "-Xlint:unchecked"))
}
