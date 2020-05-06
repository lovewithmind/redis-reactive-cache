package com.loveneesh.redis.reactive.cache.service

import com.loveneesh.redis.reactive.cache.annotation.CacheResult
import com.loveneesh.redis.reactive.cache.model.Car
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CarService {
    @CacheResult(cacheName = "car", parameterIndex = 0)
    fun getCar(modal: String): Mono<Car> {
        return Mono.just(Car("Honda", 100))
    }
}