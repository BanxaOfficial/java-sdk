package com.banxa.exception;

public class InvalidResponseException extends RuntimeException {
    public InvalidResponseException(Exception e) {
        super("Unable to parse response from API", e);
    }
}
