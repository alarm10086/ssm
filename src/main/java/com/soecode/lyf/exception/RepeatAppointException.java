package com.soecode.lyf.exception;

/**
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

    public RepeatAppointException(final String message) {
        super(message);
    }

    public RepeatAppointException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
