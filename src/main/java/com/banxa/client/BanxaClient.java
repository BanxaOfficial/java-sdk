package com.banxa.client;

public interface BanxaClient {
    String request(String method, String uri, String payload) throws Exception;
}
