package com.xiaopotian.horse.common.datasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ==========================================
 * 参考DruidDataSourceWrapper
 *
 * @author : 小破天
 * @date : 2019/7/4 15:30
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Data
@ConfigurationProperties("spring.datasource.druid")
@Component
public class DruidDataSourceProperties {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
}
