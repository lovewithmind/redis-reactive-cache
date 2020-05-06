package com.loveneesh.redis.reactive.cache.annotation

import com.loveneesh.redis.reactive.cache.service.CarService
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.memberFunctions

class CacheResultParser {

    fun parseCacheResult() {
        CarService::class.memberFunctions.forEach { function ->
            function.findAnnotation<CacheResult>()?.let { cacheResult ->
                println(cacheResult.cacheName)
            }
        }
    }

}