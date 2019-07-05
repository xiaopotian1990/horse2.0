package com.xiaopotian.horse.common.datasource.config;

import com.xiaopotian.horse.common.datasource.annotation.DynamicDataSourceAnnotation;
import com.xiaopotian.horse.common.datasource.support.DynamicDataSourceContextHolder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * ==========================================
 * AOP动态切换数据源
 *
 * @author : 小破天
 * @date : 2019/7/5 16:30
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@AllArgsConstructor
@Aspect
@Slf4j
public class DynamicDataSourceAspect {

    private final DynamicDataSourceContextHolder dynamicDataSourceContextHolder;

    /**
     * 设置数据源
     */
    @Before("@annotation(dynamicDataSource)")
    public void before(DynamicDataSourceAnnotation dynamicDataSource) {
        log.info("切换数据源start -> {}", dynamicDataSource.value());

        DynamicDataSourceContextHolder.setDataSourceType(dynamicDataSource.value().getType());
    }
}
