package com.github.lansheng228.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GuavaCache<K, T> {

    private final Cache<K, T> cache;

    // 过期时间(毫秒)
    public GuavaCache(long millSec) {
        if (millSec == 0) {
            cache = CacheBuilder.newBuilder().build();
        } else {
            // millSec 毫秒之后自动过期
            cache = CacheBuilder.newBuilder().expireAfterAccess(millSec, TimeUnit.MILLISECONDS).build();
        }
    }

    public void put(K key, T obj) {
        cache.put(key, obj);
    }

    public Map<K, T> asMap() {
        return cache.asMap();
    }

    public void update(K key, T obj) {
        cache.invalidate(key);
        cache.put(key, obj);
    }

    public T get(K key) {
        return cache.getIfPresent(key);
    }

    public void invalidateAll() {
        cache.invalidateAll();
    }

    public boolean exist(K key) {
        return cache.getIfPresent(key) != null;
    }

    public T remove(K key) {
        T value = cache.getIfPresent(key);
        cache.invalidate(key);
        return value;
    }

    public long size() {
        return cache.size();
    }
}
