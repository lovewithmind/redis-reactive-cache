package com.loveneesh.redis.reactive.cache.annotation

import org.junit.jupiter.api.Test

class CacheResultParserTest{
    @Test
    fun shouldReturnClassNameFromCacheResult() {
        CacheResultParser().parseCacheResult()
    }
}