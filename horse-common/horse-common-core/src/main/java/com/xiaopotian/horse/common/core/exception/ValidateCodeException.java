package com.xiaopotian.horse.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * ==========================================
 * 校验异常
 *
 * @author : 小破天
 * @date : 2019/6/19 15:32
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@NoArgsConstructor
public class ValidateCodeException extends Exception {
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
