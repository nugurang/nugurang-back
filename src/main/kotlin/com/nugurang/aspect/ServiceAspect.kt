package com.nugurang.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory

//@Order(Ordered.HIGHEST_PRECEDENCE)
@Aspect
//@DeclarePrecedence("org.springframework.transaction.aspectj.AnnotationTransactionAspect, *")
class ServiceAspect {
    companion object {
        private val log = LoggerFactory.getLogger(ServiceAspect::class.java)
    }

    //@Around("execution(* com.nugurang.service..*.*(..)) && @within(org.springframework.transaction.annotation.Transactional)")
    @Around("execution(* com.nugurang.service..*.*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
    //@Around("execution(@Transactional * *.*(..))")
    fun around(joinPoint: ProceedingJoinPoint): Any {
        log.error("START******************************************")
        log.error("hijacked : " + joinPoint.signature.name)
        return try {
            val result = joinPoint.proceed()
            log.error("END*************************************************")
            result
        } catch (e: Throwable) {
            log.error("Caught an throwable: $e")
            throw e
        }
    }
}