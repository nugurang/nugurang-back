import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val checkstyleVersion = "9.2.1"
val pmdVersion = "6.+"

group = "com.nugurang"
version = "0.0.1-SNAPSHOT"

plugins {
    java
    `java-library`
    id("io.freefair.aspectj.post-compile-weaving") version "6.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.6.2"
    val kotlinVersion = "1.7.20"
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
}

java {
    sourceCompatibility = JavaVersion.VERSION_14
    targetCompatibility = JavaVersion.VERSION_14
}

allOpen {
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}

noArg {
    annotation("javax.persistence.Entity")
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
        "javax.persistence:javax.persistence-api",
        "javax.annotation:javax.annotation-api",
        "org.mapstruct:mapstruct-processor:1.5.0.RC1",
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
        "net.time4j:time4j-base:5.8",
        "net.time4j:time4j-sqlxml:5.8",
        "net.time4j:time4j-tzdata:5.0-2020a",
        "net.sf.ehcache:ehcache-core:2.6.11",
        "org.aspectj:aspectjweaver:1.9.9.1",
        "org.aspectj:aspectjrt:1.9.9.1",
        "org.ehcache:ehcache",
        "org.jetbrains.kotlin:kotlin-reflect",
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8",
        "org.mapstruct:mapstruct:1.5.0.RC1",
        "org.reflections:reflections:0.10.+",
        "org.springframework.boot:spring-boot-starter-actuator",
        "org.springframework.boot:spring-boot-starter-batch",
        "org.springframework.boot:spring-boot-starter-cache",
        "org.springframework.boot:spring-boot-starter-data-jpa",
        "org.springframework.boot:spring-boot-starter-oauth2-client",
        "org.springframework.boot:spring-boot-starter-security",
        "org.springframework.boot:spring-boot-starter-test",
        "org.springframework.boot:spring-boot-starter-validation",
        "org.springframework.boot:spring-boot-starter-web",
        "org.springframework.security:spring-security-acl"
    ).map(::implementation)

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

    kapt(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")

    sourceSets.main {
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("$buildDir/generated/source/kapt/main")
        }
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
