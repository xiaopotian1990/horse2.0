package com.xiaopotian.horse.common.log;

import com.xiaopotian.horse.common.log.aspect.SysLogAspect;
import com.xiaopotian.horse.common.log.event.SysLogListener;
import com.xiaopotian.horse.common.log.init.ApplicationLoggerInitializer;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ==========================================
 * 日志自动配置
 *
 * @author : 小破天
 * @date : 2019/7/5 20:07
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener();
    }

    @Bean
    public SysLogAspect sysLogAspect(ApplicationEventPublisher publisher) {
        return new SysLogAspect(publisher);
    }

    @Bean
    public ApplicationLoggerInitializer applicationContextInitializer(){
        return new ApplicationLoggerInitializer();
    }
}
