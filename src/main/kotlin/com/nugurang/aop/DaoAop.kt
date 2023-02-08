package com.nugurang.aop

import com.nugurang.exception.NotFoundException
import com.nugurang.exception.NotIntegratedException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Component
import javax.persistence.EntityNotFoundException
import kotlin.reflect.KClass

@Component
class DaoAop(val txAop: TxAop) {
    fun <T: Any>call(returnClass: KClass<T>, function: () -> T): T = try {
        function.invoke()
    } catch (e: DataIntegrityViolationException) {
        throw NotIntegratedException(returnClass.java)
    } catch (e: EntityNotFoundException) {
        throw NotFoundException(returnClass.java)
    } catch (e: EmptyResultDataAccessException) {
        throw NotFoundException(returnClass.java)
    }

    final inline fun <reified T: Any>call(noinline function: () -> T): T = call(T::class, function)

    final inline fun <reified T: Any>txCall(noinline function: () -> T): T = call {
        txAop.call {
            function.invoke()
        }
    }
}
