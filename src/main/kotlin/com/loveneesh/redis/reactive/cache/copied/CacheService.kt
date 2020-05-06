package com.loveneesh.redis.reactive.cache.copied

import com.loveneesh.redis.reactive.cache.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import java.time.Instant

@Component
class CacheService {

    @Autowired
    private lateinit var reactiveRedisOperations: ReactiveRedisOperations<String, Person>

    fun findCache(cacheName: String, key: String, fallBackMono: Mono<Person>): Mono<Person> {
        return reactiveRedisOperations.opsForValue().get(key)
                .switchIfEmpty {
                    fallBackMono.map { person ->
                        reactiveRedisOperations.opsForValue().set(key, person).flatMap {
                            reactiveRedisOperations.expireAt(key, Instant.now().plusSeconds(10))
                        }.subscribe()

                        person
                    }
                }

    }
}