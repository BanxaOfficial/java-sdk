package com.banxa.service;

import com.banxa.client.BanxaClient;
import com.banxa.client.BanxaClientResponse;
import com.banxa.exception.InvalidResponseException;
import com.banxa.model.request.*;
import com.banxa.model.response.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Locale;

/**
 *
 */
public class BanxaServiceImpl implements BanxaService {

    private final BanxaClient banxaClient;

    public BanxaServiceImpl(BanxaClient banxaClient) {
        this.banxaClient = banxaClient;
    }

    public <T> BanxaResponse<T> request(Request<T> request) {
        try {
            String payload = request.getPayload();
            String uri = request.getUri();

            BanxaClientResponse response = banxaClient.request(request.getMethod(), uri, payload);

            if (response.isSuccessful()) {
                return buildResponse(request.getResponseClass(), response.getBody());
            } else {
                return new BanxaResponse<>(new ErrorResponse(response.getCode(), response.getBody()));
            }
        } catch(Exception e) {
            return new BanxaResponse<>(new ErrorResponse(ErrorResponse.DEFAULT_ERROR_STATUS_CODE, e.getMessage()));
        }
    }

    private static <T> BanxaResponse<T> buildResponse(Class<T> responseClass, String response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setLocale(Locale.US);
        mapper.registerModule(new JavaTimeModule());
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            // To ensure this can be converted from JSON properly we need to strip out the data and meta nodes
            JsonNode root = mapper.readTree(response);
            String content = mapper.writeValueAsString(root.findValue("data"));

            JsonNode metaNode = root.findValue("meta");
            Pagination pagination = null;
            if (metaNode != null) {
                String metaText = mapper.writeValueAsString(metaNode);
                pagination = mapper.readValue(metaText, Pagination.class);
            }

            return new BanxaResponse<>(mapper.readValue(content, responseClass), pagination);
        } catch (Exception e) {
            throw new InvalidResponseException(e);
        }
    }
}
