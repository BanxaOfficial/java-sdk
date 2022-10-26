package com.banxa.exception;

public class SystemErrorException extends RuntimeException {
    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
