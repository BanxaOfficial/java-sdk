package com.banxa.client;

import com.banxa.authentication.Authentication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class BanxaClientImpl implements BanxaClient {
    /**
     * The production environment
     */
    private static final String PRODUCTION_URL = "https://{subdomain}.banxa.com";

    /**
     * The sandbox environment
     */
    private static final String SANDBOX_URL = "https://{subdomain}.banxa-sandbox.com";

    private final Authentication authentication;
    private String baseUrl;

    public BanxaClientImpl(String subdomain, String apiKey, String apiSecret, boolean testMode) {
        this.baseUrl = testMode ? SANDBOX_URL : PRODUCTION_URL;
        this.baseUrl = this.baseUrl.replace("{subdomain}", subdomain);
        this.authentication = new Authentication(apiKey, apiSecret);
    }

    @Override
    public String request(String method, String uri, String payload) throws Exception {
        long nonce = System.currentTimeMillis();
        String authToken = this.authentication.generateAuthToken(method, uri, payload, nonce);
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(this.baseUrl + uri))
                .timeout(Duration.ofSeconds(10))
                .header("Authorization", "Bearer " + authToken)
                .header("content-type", "application/json");

        if (method.equals("GET")) {
            builder.GET();
        } else if (method.equals("POST")) {
            builder.POST(HttpRequest.BodyPublishers.ofString(payload));
        }

        HttpRequest request = builder.build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // TODO need to handle this better (potentially throw an exception or need to build a better response object)
        if (response.statusCode() == 200) {
            System.out.println("OK");
        } else {
            System.out.println("Failed: " + response.statusCode());
        }
        return response.body();
    }
}
