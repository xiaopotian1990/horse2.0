package com.xiaopotian.horse.biz.order.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ==========================================
 *
 * @author : 小破天
 * @date : 2019/6/18 15:22
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test() {
        //System.getProperty("appId");
        log.info("环境变量【java.version】：{}",System.getProperty("java.version"));
        return System.getProperty("appId");
    }
}
