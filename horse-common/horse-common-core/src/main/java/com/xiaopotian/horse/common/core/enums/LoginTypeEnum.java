package com.xiaopotian.horse.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ==========================================
 * 社交登录类型
 *
 * @author : 小破天
 * @date : 2019/6/18 21:34
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
    /**
     * 账号密码登录
     */
    PWD("PWD", "账号密码登录"),

    /**
     * 验证码登录
     */
    SMS("SMS", "验证码登录"),

    /**
     * QQ登录
     */
    QQ("QQ", "QQ登录"),

    /**
     * 微信登录
     */
    WECHAT("WX", "微信登录"),

    /**
     * 码云登录
     */
    GITEE("GITEE", "码云登录"),

    /**
     * 开源中国登录
     */
    OSC("OSC", "开源中国登录");

    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
}

