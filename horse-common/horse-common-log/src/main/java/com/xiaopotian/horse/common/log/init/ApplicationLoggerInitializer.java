package com.xiaopotian.horse.common.log.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * ==========================================
 * 初始化日志路径
 *
 * @author : 小破天
 * @date : 2019/7/5 19:08
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
public class ApplicationLoggerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        String appName = environment.getProperty("spring.application.name");

        String logBase = environment.getProperty("LOGGING_PATH", "logs");
        // spring boot admin 直接加载日志
        System.setProperty("logging.file", String.format("%s/%s/debug.log", logBase, appName));
    }
}
