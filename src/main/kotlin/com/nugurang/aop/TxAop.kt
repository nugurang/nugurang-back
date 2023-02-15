package com.nugurang.aop

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TxAop {
    @Transactional
    fun <T> call(function: () -> T): T = function.invoke()
}