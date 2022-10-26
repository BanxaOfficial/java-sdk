package com.banxa.client;

public class BanxaClientResponse {
    private final int code;
    private final String body;

    public BanxaClientResponse(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccessful() {
        return this.code == 200;
    }

    public String getBody() {
        return body;
    }
}
