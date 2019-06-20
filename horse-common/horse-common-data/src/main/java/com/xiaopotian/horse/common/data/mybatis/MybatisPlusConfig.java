package com.xiaopotian.horse.common.data.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * ==========================================
 *
 * @author : 小破天
 * @date : 2019/6/19 21:20
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Configuration
@ConditionalOnBean(DataSource.class)
@MapperScan("com.xiaopotian.horse.**.mapper")
public class MybatisPlusConfig {

}
