package com.skypro.algorithm2lion.homework;

public class SetIsFullException extends Throwable {
    public SetIsFullException() {
    }

    public SetIsFullException(String message) {
        super(message);
    }

    public SetIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetIsFullException(Throwable cause) {
        super(cause);
    }

    public SetIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
