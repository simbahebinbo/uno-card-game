package com.github.lansheng228.controller;

import com.github.lansheng228.config.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * WebSocketController
 *
 * @author zhengkai.blog.csdn.net
 */
@RestController
public class DemoController {

    @GetMapping("/demo/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("/demo/page")
    public ModelAndView page() {
        return new ModelAndView("websocket");
    }

    @RequestMapping("/demo/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}
