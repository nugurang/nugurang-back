package com.nugurang.config

import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableLoadTimeWeaving
import org.springframework.transaction.annotation.EnableTransactionManagement

//https://guypaddock.github.io/posts/aspectj-native-syntax-with-spring-ltw-and-gradle/
//https://github.com/pk044/spring-boot-ltw/blob/master/src/main/java/hello/config/AppConfig.java
//https://stackoverflow.com/questions/34299066/how-to-configure-spring-boot-application-to-use-aspectj-transactions
@Configuration
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
class AspectJConfig