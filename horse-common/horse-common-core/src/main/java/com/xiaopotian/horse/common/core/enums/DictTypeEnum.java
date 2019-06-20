package com.xiaopotian.horse.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================================
 * 字典类型
 *
 * @author : 小破天
 * @date : 2019/6/18 21:35
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Getter
@AllArgsConstructor
public enum DictTypeEnum {
    /**
     * 字典类型-系统内置（不可修改）
     */
    SYSTEM("1", "系统内置"),

    /**
     * 字典类型-业务类型
     */
    BIZ("0", "业务类");

    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
}
