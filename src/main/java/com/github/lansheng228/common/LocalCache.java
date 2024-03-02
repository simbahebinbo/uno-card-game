package com.github.lansheng228.common;

public interface LocalCache {

    boolean exist(String key);

    // 缓存时间: 毫秒
    void put(String key, Object value, long cacheTime);

    void put(String key, Object value);

    LocalCacheEntity get(String key);

    void update(String key, Object value);

    LocalCacheEntity remove(String key);

    long size();
}
