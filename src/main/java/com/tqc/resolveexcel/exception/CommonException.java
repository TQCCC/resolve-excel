package com.tqc.resolveexcel.exception;

/**
 * Created by tangqingchang on 2017/12/4.
 * 统一出错异常
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 7676678142982623768L;

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
