package com.xiaopotian.horse.common.datasource.annotation;

import com.xiaopotian.horse.common.datasource.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * ==========================================
 * 动态数据源注解
 *
 * @author : 小破天
 * @date : 2019/7/5 17:03
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicDataSourceAnnotation {
    /**
     * 描述  数据源类型
     *
     * @return DataSourceType
     */
    DataSourceType value();
}
