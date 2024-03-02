package com.github.lansheng228.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.net.URI;

@Slf4j
@Component
public class InternalWebFilter implements WebFilter {

    @PostConstruct
    public void init() {
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        long startTime = System.currentTimeMillis();
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        String path = uri.getPath();
        String rawPath = uri.getRawPath();

        log.info("过滤器");
        
        if (log.isDebugEnabled()) {
            log.debug("路径: " + path + "   原始路径:  " + rawPath + "  进入到过滤器 " + this);
        }

        return chain.filter(exchange).doAfterTerminate(() -> {
                    exchange.getResponse().getHeaders().forEach((k, v) -> {
                                if (log.isDebugEnabled()) {
                                    log.debug("Response header '{}': {}", k, v);
                                }
                            }
                    );

                    if (log.isDebugEnabled()) {
                        log.debug("Served '{}' as {} in {} msec",
                                path,
                                exchange.getResponse().getStatusCode(),
                                System.currentTimeMillis() - startTime);
                    }
                }
        ).then(
                Mono.fromRunnable(() -> {
                    if (log.isDebugEnabled()) {
                        log.debug(rawPath + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                }));
    }
}



