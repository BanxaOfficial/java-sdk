package com.banxa.model.response;

public class ErrorResponse {
    public static final int DEFAULT_ERROR_STATUS_CODE = 500;

    private String message;
    private int statusCode;

    public ErrorResponse(int statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
