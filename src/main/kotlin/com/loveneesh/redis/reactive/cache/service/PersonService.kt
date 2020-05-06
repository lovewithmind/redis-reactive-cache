package com.loveneesh.redis.reactive.cache.service

import com.loveneesh.redis.reactive.cache.copied.CacheService
import com.loveneesh.redis.reactive.cache.model.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PersonService {
    val logger: Logger = LoggerFactory.getLogger(PersonService::class.java)

    @Autowired
    lateinit var cacheService: CacheService

    fun getPersonByName(name: String): Mono<Person> {
        val fallBackMono = Mono.fromCallable {
            logger.info("Mai jannat me hu -> get Person By Name called")
            Person("lili", 18)
        }

        return cacheService.findCacheValue("person", name, fallBackMono)
    }

    fun oneMoreMethod(name: String): Mono<Person> {
        val fallBackMono = Mono.fromCallable {
            logger.info("Mai jannat me hu -> get Person By Name called")
            Person("lili", 18)
        }

        return cacheService.findCache("person", name, fallBackMono)
    }
}