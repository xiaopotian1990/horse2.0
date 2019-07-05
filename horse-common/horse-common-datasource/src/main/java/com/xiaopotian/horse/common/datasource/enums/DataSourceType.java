package com.xiaopotian.horse.common.datasource.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================================
 * 数据源类型
 *
 * @author : 小破天
 * @date : 2019/7/5 16:56
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Getter
@AllArgsConstructor
public enum DataSourceType {
    /**
     * 网关
     */
    GATEWAY(1, "网关");

    /**
     * 类型
     */
    private final int type;
    /**
     * 描述
     */
    private final String description;
}
