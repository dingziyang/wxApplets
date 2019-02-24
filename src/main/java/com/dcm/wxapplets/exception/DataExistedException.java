package com.dcm.wxapplets.exception;

/**
 * @ClassName: FormValidException
 * @Description: 自定义的数据已存在校验，运行时异常
 * @Auther: dcm
 * @Date: 2018-7-3 15:49
 */

public class DataExistedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataExistedException() {
        super();
    }

    public DataExistedException(String message) {
        super(message);
    }

    public DataExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataExistedException(Throwable cause) {
        super(cause);
    }

    protected DataExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
