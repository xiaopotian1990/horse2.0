package com.xiaopotian.horse.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * ==========================================
 * 校验异常
 *
 * @author : 小破天
 * @date : 2019/6/19 15:30
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@NoArgsConstructor
public class CheckedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
