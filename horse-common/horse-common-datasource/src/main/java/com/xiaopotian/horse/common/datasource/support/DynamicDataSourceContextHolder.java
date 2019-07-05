package com.xiaopotian.horse.common.datasource.support;

import lombok.experimental.UtilityClass;

/**
 * ==========================================
 * 根据当前线程来选择具体的数据源
 *
 * @author : 小破天
 * @date : 2019/7/4 16:49
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@UtilityClass
public class DynamicDataSourceContextHolder {
    private final ThreadLocal<Integer> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 提供给AOP去设置当前的线程的数据源的信息
     *
     * @param dataSourceType 数据源类型
     */
    public void setDataSourceType(Integer dataSourceType) {
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * 提供给AbstractRoutingDataSource的实现类，通过key选择数据源
     *
     * @return 数据源类型
     */
    public Integer getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 使用默认的数据源
     */
    public void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }
}
