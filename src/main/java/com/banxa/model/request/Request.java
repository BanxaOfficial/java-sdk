package com.banxa.model.request;

public interface Request {
    String getUri();
    String getMethod();
    String getPayload() throws Exception;
}
