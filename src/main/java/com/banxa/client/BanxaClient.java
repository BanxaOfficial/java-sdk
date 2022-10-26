package com.banxa.client;

public interface BanxaClient {
    BanxaClientResponse request(String method, String uri, String payload);
}
