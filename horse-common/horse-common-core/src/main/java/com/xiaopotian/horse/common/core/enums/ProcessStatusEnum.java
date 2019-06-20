package com.xiaopotian.horse.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================================
 * 流程状态
 *
 * @author : 小破天
 * @date : 2019/6/18 21:32
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Getter
@AllArgsConstructor
public enum ProcessStatusEnum {
    /**
     * 激活
     */
    ACTIVE("active", "激活"),

    /**
     * 挂起
     */
    SUSPEND("suspend", "挂起");

    /**
     * 类型
     */
    private final String status;
    /**
     * 描述
     */
    private final String description;
}
