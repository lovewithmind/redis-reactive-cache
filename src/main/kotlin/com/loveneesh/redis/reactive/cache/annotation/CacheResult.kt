package com.loveneesh.redis.reactive.cache.annotation

@Target(AnnotationTarget.FUNCTION)
annotation class CacheResult(val cacheName: String, val parameterName: String)