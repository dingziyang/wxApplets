package com.dcm.wxapplets.exception;

/**
 * @ClassName: FormValidException
 * @Description: 自定义的表单校验，运行时异常
 * @Auther: dcm
 * @Date: 2018-7-3 15:49
 */

public class FormValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FormValidException() {
        super();
    }

    public FormValidException(String message) {
        super(message);
    }

    public FormValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormValidException(Throwable cause) {
        super(cause);
    }

    protected FormValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
