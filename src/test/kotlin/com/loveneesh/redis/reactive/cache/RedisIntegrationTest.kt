package com.loveneesh.redis.reactive.cache

import com.loveneesh.redis.reactive.cache.service.PersonService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisIntegrationTest {
    @Autowired
    private lateinit var personService: PersonService

    @Test
    fun `should get person from cache`() {
        personService.getPersonByName("lili").block()

        personService.getPersonByName("lili").block()
    }

    @Test
    fun `should gem cache`() {
        personService.oneMoreMethod("lili").block()

        personService.oneMoreMethod("lili").block()
    }
}