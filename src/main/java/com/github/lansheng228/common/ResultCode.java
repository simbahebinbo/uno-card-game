package com.github.lansheng228.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200, "ok", "处理成功"),
    FAIL(500, "system.error", "系统异常");


    /**
     * 返回码
     */
    @Getter
    private int code;
    /**
     * 返回码描述 采用小写英文字母，单词用英文点号.分割，建议格式：$业务类别.$业务子类.$错误项。
     */
    @Getter
    private String message;
    /**
     * 说明
     */
    @Getter
    private String desc;
}

