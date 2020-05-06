package com.loveneesh.redis.reactive.cache.annotation

import com.loveneesh.redis.reactive.cache.model.Person
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Component
@Aspect
class CacheResultAspect {
    @Autowired
    private lateinit var reactiveRedisOperations: ReactiveRedisOperations<String, Person>

    @Around("execution(* *.*(..)) && @annotation(cacheResult)")
    fun runBeforeMethod(proceedingJoinPoint: ProceedingJoinPoint, cacheResult: CacheResult): Any {
        val key = proceedingJoinPoint.args[cacheResult.parameterIndex] as String
        return reactiveRedisOperations.opsForValue().get(key)
                .switchIfEmpty {
                    (proceedingJoinPoint.proceed() as Mono<Person>).map { person ->
                        reactiveRedisOperations.opsForValue().set(key, person).subscribe()
                        person
                    }
                }
    }
}