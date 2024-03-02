package com.github.lansheng228.common;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonConstant {

    public static final String UTF8 = "UTF-8";

    //HEADER
    public static final String X_FORWARDED_HOST = "X-Forwarded-Host";
    public static final String HOST = "Host";
    public static final String CF_CONNECTING_IP = "CF-Connecting-IP";
    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REAL_IP = "x-real-ip";
    public static final String X_FORWARDED_PREFIX = "X-Forwarded-Prefix";
    public static final String CONTENT_TYPE = "content-type";

    public static final String LOCAL_ADDRESS = "localhost";
    
    public static final String WS_LINK = "/ws";
    public static final String WS_SUB = "sub";
    public static final String WS_REQ = "req";
    public static final String WS_UNSUB = "unsub";

    public static final String NP_REQ = "req";

    public static final String SUFFIX = "$sub";


    /***
     *   时间相关
     */
    public static final String TIME_ZONE = "Asia/Shanghai";

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    //GMT+8 to UTC ,相差8小时 8 * 3600 = 28800 秒
    public static final int CONVERT_UTC_DIFFER = 28800;

    public static final String JSON_TYPE = "application/json;charset=UTF-8";

    /**
     * 分隔符
     */
    public static final String SEPARATOR_SEMICOLON = ";";

    public static final String SEPARATOR_QUESTION_MARK = "?";

    public static final String SEPARATOR_COLON = ":";

    public static final String SEPARATOR_COLON2 = "::";

    public static final String SEPARATOR_COMMA = ",";

    public static final String SEPARATOR_AMPERSAND = "&";

    public static final String SEPARATOR_EQUAL_SIGN = "=";

    /**
     * 斜线
     */
    public static final String SEPARATOR_VIRGULE = "/";

    public static final String SEPARATOR_BLANK = "";

    public static final String SEPARATOR_ASTERISK = "*";

    /**
     * 竖线
     */
    public static final String SEPARATOR_VERTICAL_LINE = "|";

    /**
     * 下划线
     */
    public static final String SEPARATOR_UNDERSCORE = "_";
    /**
     * 连字符 中横线
     */
    public static final String SEPARATOR_HYPHEN = "-";


    /**
     * 大数的精度
     */
    public static final Integer SCALE = 18;


    /**
     * url
     */

    public static final String URL_PING = "/ping";

    /**
     * http方法
     */

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";

    public static final int WS_PORT = 80;

    public static final int WSS_PORT = 443;

    public static final String WS_SCHEME = "ws";

    public static final String WSS_SCHEME = "wss";

    /**
     * 默认redis的端口。用于单元测试。
     */
    public static final int DEFAULT_REDIS_PORT = 6379;
}


