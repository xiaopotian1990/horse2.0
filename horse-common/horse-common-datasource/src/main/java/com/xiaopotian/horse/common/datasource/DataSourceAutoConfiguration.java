package com.xiaopotian.horse.common.datasource;

import com.xiaopotian.horse.common.datasource.config.DruidDataSourceProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * ==========================================
 * 自动配置类
 *
 * @author : 小破天
 * @date : 2019/7/5 10:08
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@AllArgsConstructor
@EnableConfigurationProperties(DruidDataSourceProperties.class)
public class DataSourceAutoConfiguration {
}
