package com.loveneesh.redis.reactive.cache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisReactiveCacheApplication

fun main(args: Array<String>) {
    runApplication<RedisReactiveCacheApplication>(*args)
}
