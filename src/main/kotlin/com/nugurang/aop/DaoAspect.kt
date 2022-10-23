package com.nugurang.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class DaoAspect(private val daoAop: DaoAop) {
    @Around("@annotation(com.nugurang.annotation.DaoOp)")
    fun daoOp(joinPoint: ProceedingJoinPoint): Any? = daoAop.txCall {
        joinPoint.proceed()
    }
}