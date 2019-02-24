package com.dcm.wxapplets.exception;

/**
 * @ClassName: FormValidException
 * @Description: 自定义的Session失效异常，运行时异常
 * @Auther: dcm
 * @Date: 2018-7-3 15:49
 */

public class SessionInvalidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SessionInvalidException() {
        super();
    }

    public SessionInvalidException(String message) {
        super(message);
    }

    public SessionInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionInvalidException(Throwable cause) {
        super(cause);
    }

    protected SessionInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
