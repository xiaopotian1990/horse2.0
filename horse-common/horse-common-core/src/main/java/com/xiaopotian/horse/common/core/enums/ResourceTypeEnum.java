package com.xiaopotian.horse.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================================
 * 资源类型
 *
 * @author : 小破天
 * @date : 2019/6/18 21:30
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Getter
@AllArgsConstructor
public enum ResourceTypeEnum {
    /**
     * 图片资源
     */
    IMAGE("image", "图片资源"),

    /**
     * xml资源
     */
    XML("xml", "xml资源");

    /**
     * 类型
     */
    private final String type;
    /**
     * 描述
     */
    private final String description;
}
