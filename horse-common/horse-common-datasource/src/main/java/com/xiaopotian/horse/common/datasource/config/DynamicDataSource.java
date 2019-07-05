package com.xiaopotian.horse.common.datasource.config;

import com.xiaopotian.horse.common.datasource.support.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ==========================================
 * 动态数据源类
 *
 * @author : 小破天
 * @date : 2019/7/4 15:35
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 指定路由Key
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
