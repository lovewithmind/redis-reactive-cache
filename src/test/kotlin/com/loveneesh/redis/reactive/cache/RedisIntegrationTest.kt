package com.loveneesh.redis.reactive.cache

import com.loveneesh.redis.reactive.cache.service.PersonService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisIntegrationTest {
    @Autowired
    private lateinit var personService: PersonService

    @Test
    fun `should gem cache`() {
        personService.oneMoreMethod("lili").block()

        personService.oneMoreMethod("lili").block()
    }
}