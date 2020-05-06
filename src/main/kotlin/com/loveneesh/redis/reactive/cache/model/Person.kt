package com.loveneesh.redis.reactive.cache.model

data class Person(val name: String, val age: Int) {
    constructor() : this("null", 12)
}