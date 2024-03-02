package com.github.lansheng228.filter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.setAllowedMethods(new ArrayList<>(Arrays.asList("OPTIONS", "HEAD", "TRACE", "CONNECT", "POST", "GET", "PATCH", "DELETE", "PUT")));
        config.setAllowedHeaders(new ArrayList<>(Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Accept")));
        config.setMaxAge(3600L);

        // 创建CorsWebFilter并返回
        return new CorsWebFilter(source -> config);
    }
}

