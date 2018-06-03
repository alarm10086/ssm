package com.soecode.lyf.exception;

/**
 * 预约业务异常
 */
public class AppointException extends RuntimeException {

    public AppointException(final String message) {
        super(message);
    }

    public AppointException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
