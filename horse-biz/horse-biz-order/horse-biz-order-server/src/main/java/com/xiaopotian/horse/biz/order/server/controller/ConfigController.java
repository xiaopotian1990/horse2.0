package com.xiaopotian.horse.biz.order.server.controller;

import com.xiaopotian.horse.biz.order.server.config.HorseConfigProperties;
import com.xiaopotian.horse.biz.order.server.view.ConfigVM;
import com.xiaopotian.horse.common.log.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ==========================================
 * Created with IntelliJ IDEA.
 * User: 小破天
 * Date: 2019-04-05
 * Time: 20:14
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@RestController
@Slf4j
public class ConfigController {
    @Autowired
    private HorseConfigProperties config;
    @Autowired
    private RedisTemplate horseRedisTemplate;

    @GetMapping("/config")
    @SysLog("config")
    //@Cacheable(value = "config",key = "#param")
    public ConfigVM config(@RequestParam Integer param) {
        int i = 1 / param;
        log.info("name:{};age:{}", config.getName(), config.getAge());
        ConfigVM vm = new ConfigVM(config.getName(), config.getAge());
        horseRedisTemplate.opsForValue().set("config",vm);
        return vm;
    }

    @GetMapping("/config/delete")
    @CacheEvict(value = "config",key = "#param")
    public Boolean delete(@RequestParam Integer param){
        return true;
    }
}
