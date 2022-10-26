package com.banxa.model.request;

public interface Request<T> {
    String getUri();
    String getMethod();
    String getPayload() throws Exception;

    Class<T> getResponseClass();
}
