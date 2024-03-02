package com.github.lansheng228.common;

import com.github.lansheng228.toolkit.DateTool;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class CustomLocalCache implements LocalCache {

    // 键值对集合
    private final GuavaCache<String, LocalCacheEntity> cache;

    // 过期时间(毫秒) 0: 永不过期
    public CustomLocalCache(long millSec) {
        cache = new GuavaCache<>(millSec);
    }

    /**
     * 判断缓存是否存在
     *
     * <p>key 键
     */
    @Override
    public boolean exist(String key) {
        long currentTime = DateTool.currentTimeMillis();
        LocalCacheEntity entity = cache.get(key);
        boolean flag = false;

        if (entity != null) {
            if ((entity.getExpireTime() > 0) && (currentTime > entity.getExpireTime())) {
                cache.remove(key);
            } else {
                flag = true;
            }
        }

        return flag;
    }

    /**
     * 缓存值 不设置过期时间
     */
    @Override
    public void put(String key, Object value) {
        put(key, value, 0);
    }

    /**
     * 缓存值-指定缓存时间
     *
     * <p>expireTime 缓存时间 单位: 毫秒
     */
    @Override
    public void put(String key, Object value, long expire) {
        if (expire > 0) {
            long currentTime = DateTool.currentTimeMillis();
            cache.put(key, new LocalCacheEntity(value, expire + currentTime));
        } else if (expire == 0) {
            // 永不过期
            cache.put(key, new LocalCacheEntity(value, Long.MAX_VALUE));
        }
    }

    /**
     * 读取缓存
     *
     * <p>key 键
     */
    @Override
    public LocalCacheEntity get(String key) {
        long currentTime = DateTool.currentTimeMillis();
        LocalCacheEntity ret = null;

        LocalCacheEntity entity = cache.get(key);
        if (entity != null) {
            if ((entity.getExpireTime() > 0) && (currentTime > entity.getExpireTime())) {
                cache.remove(key);
            } else {
                ret = entity;
            }
        }

        return ret;
    }

    /**
     * 更新缓存
     *
     * <p>key 键
     *
     * <p>data 值
     */
    @Override
    public void update(String key, Object value) {
        long currentTime = DateTool.currentTimeMillis();
        LocalCacheEntity entity = cache.get(key);

        if (entity != null) {
            if ((entity.getExpireTime() > 0) && (currentTime > entity.getExpireTime())) {
                cache.remove(key);
            } else {
                entity.setValue(value);
                cache.put(key, entity);
            }
        }
    }

    /**
     * 清除缓存
     */
    @Override
    public LocalCacheEntity remove(String key) {
        long currentTime = DateTool.currentTimeMillis();
        LocalCacheEntity ret = null;

        // 清除原缓存数据
        LocalCacheEntity entity = cache.remove(key);
        if (entity != null) {
            if ((entity.getExpireTime() > 0) && (currentTime <= entity.getExpireTime())) {
                ret = entity;
            } else {
                ret = null;
            }
        }

        return ret;
    }

    /**
     * 查询当前缓存的键值对数量
     */
    @Override
    public long size() {
        AtomicLong size = new AtomicLong();
        long currentTime = DateTool.currentTimeMillis();
        cache
                .asMap()
                .forEach(
                        (k, v) -> {
                            if ((k != null) && (v != null)) {
                                // 过期了移除缓存
                                if ((v.getExpireTime() > 0) && (currentTime > v.getExpireTime())) {
                                    cache.remove(k);
                                } else {
                                    size.set(size.get() + 1);
                                }
                            }
                        });

        return size.get();
    }
}
