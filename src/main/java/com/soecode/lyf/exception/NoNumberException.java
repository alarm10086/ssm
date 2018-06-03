package com.soecode.lyf.exception;

/**
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException {

    public NoNumberException(final String message) {
        super(message);
    }

    public NoNumberException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
