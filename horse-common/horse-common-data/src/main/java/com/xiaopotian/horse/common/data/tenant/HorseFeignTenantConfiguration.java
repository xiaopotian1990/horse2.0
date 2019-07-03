package com.xiaopotian.horse.common.data.tenant;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ==========================================
 * feign 租户信息拦截
 *
 * @author : 小破天
 * @date : 2019/6/20 18:28
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Configuration
public class HorseFeignTenantConfiguration {
    @Bean
    public RequestInterceptor horseFeignTenantInterceptor() {
        return new HorseFeignTenantInterceptor();
    }
}
