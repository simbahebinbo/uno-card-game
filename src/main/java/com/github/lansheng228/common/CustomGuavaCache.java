package com.github.lansheng228.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomGuavaCache<K, T> {

    private final GuavaCache<K, T> cache;

    public CustomGuavaCache() {
        cache = new GuavaCache<>(0);
    }

    public void put(K key, T obj) {
        cache.put(key, obj);
    }

    public T get(K key) {
        return cache.get(key);
    }

    public void invalidateAll() {
        cache.invalidateAll();
    }

    public boolean exist(K key) {
        return cache.exist(key);
    }

    public long size() {
        return cache.size();
    }
}
