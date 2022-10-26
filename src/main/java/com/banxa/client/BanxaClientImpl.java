package com.banxa.client;

import com.banxa.authentication.Authentication;
import com.banxa.exception.InvalidCredentialsException;
import com.banxa.exception.SystemErrorException;

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
    public BanxaClientResponse request(String method, String uri, String payload) {
        long nonce = System.currentTimeMillis();
        String authToken = null;

        try {
            authToken = this.authentication.generateAuthToken(method, uri, payload, nonce);
        } catch (Exception e) {
            throw new InvalidCredentialsException("API Key or Secret either not provided or invalid");
        }

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

        try {
            HttpRequest request = builder.build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return new BanxaClientResponse(response.statusCode(), response.body());
        } catch (Exception e) {
            throw new SystemErrorException("Error making API call to Banxa", e);
        }
    }
}
