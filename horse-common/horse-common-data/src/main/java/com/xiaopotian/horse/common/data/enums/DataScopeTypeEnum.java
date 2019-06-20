package com.xiaopotian.horse.common.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================================
 * 数据权限类型
 *
 * @author : 小破天
 * @date : 2019/6/19 20:56
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Getter
@AllArgsConstructor
public enum DataScopeTypeEnum {
    /**
     * 查询全部数据
     */
    ALL(0, "全部"),

    /**
     * 自定义
     */
    CUSTOM(1, "自定义"),

    /**
     * 本级及子级
     */
    OWN_CHILD_LEVEL(2, "本级及子级"),

    /**
     * 本级
     */
    OWN_LEVEL(3, "本级");

    /**
     * 类型
     */
    private final int type;
    /**
     * 描述
     */
    private final String description;
}
