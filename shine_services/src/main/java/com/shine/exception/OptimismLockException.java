package com.shine.exception;

/**
 * 乐观锁异常
 * Created by hq on 2016/11/04.
 */
public class OptimismLockException extends RuntimeException {
    private static final long serialVersionUID = 7154063185597736021L;

    public OptimismLockException() {
        super();
    }

    public OptimismLockException(String message) {
        super(message);
    }

    public OptimismLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptimismLockException(Throwable cause) {
        super(cause);
    }

    protected OptimismLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
