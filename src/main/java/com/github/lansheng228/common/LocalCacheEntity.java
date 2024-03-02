package com.github.lansheng228.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 缓存项
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LocalCacheEntity {

    // 缓存值
    private Object value;

    // 过期时间(毫秒)
    private long expireTime;
}
