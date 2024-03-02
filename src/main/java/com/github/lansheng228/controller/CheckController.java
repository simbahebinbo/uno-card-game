package com.github.lansheng228.controller;


import com.github.lansheng228.common.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
public class CheckController {

    @GetMapping(CommonConstant.URL_PING)
    public Mono<String> check() {
        return Mono.just("pong");
    }
}



