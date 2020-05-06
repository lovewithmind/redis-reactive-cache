//package com.loveneesh.redis.reactive.cache.copied;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import reactor.cache.CacheMono;
//import reactor.core.publisher.Mono;
//import reactor.core.publisher.Signal;
//
//import java.util.List;
//
//public class BaseService<E extends GenericEntity> {
//
//
//
//    public Mono<E> findCacheValue(String cacheName, List<String> keys, Mono<E> fallBackMono) {
//        return CacheMono
//                .lookup(k -> findCacheValue(cacheName, keys).map(Signal::next), keys)
//                .onCacheMissResume(fallBackMono)
//                    .andWriteWith((k, sig) -> Mono.fromRunnable(() ->
//                        writeCacheValue(cacheName,keys,sig.get())));
//    }
//
//
//    public Mono<E> writeCacheValue(String cacheName, List<String> keys, E data) {
//        if(data != null) {
//            hazlecastService.getHzInstance().getMap(cacheName).set(createKey(keys),data);
//            return Mono.just(data);
//        }
//        return Mono.empty();
//    }
//
//    public Flux<E> writeCacheValues(String cacheName, List<String> keys, List<E> data) {
//        hazlecastService.getHzInstance().getMap(cacheName).set(createKey(keys),data);
//        return Flux.fromIterable(data);
//    }
//
//    public void evictValue(String cacheName, List<String> keys) {
//        hazlecastService.getHzInstance().getMap(cacheName).evict(createKey(keys));
//    }
//
//}