package com.dcm.wxapplets.exception;

/**
 * @ClassName: FormValidException
 * @Description: 自定义的错误操作异常，运行时异常
 * @Auther: dcm
 * @Date: 2018-7-3 15:49
 */

public class FalseActionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FalseActionException() {
        super();
    }

    public FalseActionException(String message) {
        super(message);
    }

    public FalseActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FalseActionException(Throwable cause) {
        super(cause);
    }

    protected FalseActionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
