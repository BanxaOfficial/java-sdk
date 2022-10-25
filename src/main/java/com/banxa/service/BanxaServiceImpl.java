package com.banxa.service;

import com.banxa.client.BanxaClient;
import com.banxa.model.request.*;
import com.banxa.model.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Locale;

public class BanxaServiceImpl implements BanxaService {

    private final BanxaClient banxaClient;

    public BanxaServiceImpl(BanxaClient banxaClient) {
        this.banxaClient = banxaClient;
    }

    @Override
    public BanxaResponse<GetFiatCurrenciesResponse> getFiatCurrencies(GetFiatCurrenciesRequest request) {
        return request(request, GetFiatCurrenciesResponse.class);
    }

    @Override
    public BanxaResponse<GetCryptoCurrenciesResponse> getCryptoCurrencies(GetCryptoCurrenciesRequest request) {
        return request(request, GetCryptoCurrenciesResponse.class);
    }

    @Override
    public BanxaResponse<GetCountriesResponse> getCountries(GetCountriesRequest request) {
        return request(request, GetCountriesResponse.class);
    }

    @Override
    public BanxaResponse<GetUsStatesResponse> getUsStates(GetUsStatesRequest request) {
        return request(request, GetUsStatesResponse.class);
    }

    @Override
    public BanxaResponse<GetPaymentMethodsResponse> getPaymentMethods(GetPaymentMethodsRequest request) {
        return request(request, GetPaymentMethodsResponse.class);
    }

    @Override
    public BanxaResponse<GetPricesResponse> getPrices(GetPricesRequest request) {
        return request(request, GetPricesResponse.class);
    }

    @Override
    public BanxaResponse<GetOrderResponse> getOrder(GetOrderRequest request) {
        return request(request, GetOrderResponse.class);
    }

    @Override
    public BanxaResponse<GetOrdersResponse> getOrders(GetOrdersRequest request) {
        return request(request, GetOrdersResponse.class);
    }

    @Override
    public BanxaResponse<CreateBuyOrderResponse> createBuyOrder(CreateBuyOrderRequest request) {
        return request(request, CreateBuyOrderResponse.class);
    }

    @Override
    public BanxaResponse<CreateSellOrderResponse> createSellOrder(CreateSellOrderRequest request) {
        return request(request, CreateSellOrderResponse.class);
    }

    @Override
    public BanxaResponse<CreateNftOrderResponse> createNftOrder(CreateNftOrderRequest request) {
        return request(request, CreateNftOrderResponse.class);
    }

    @Override
    public BanxaResponse<ConfirmSellOrderResponse> confirmSellOrder(ConfirmSellOrderRequest request) {
        return request(request, ConfirmSellOrderResponse.class);
    }

    @Override
    public BanxaResponse<CreateIdentityResponse> createIdentity(CreateIdentityRequest request) {
        return request(request, CreateIdentityResponse.class);
    }

    private <T> BanxaResponse<T> request(Request request, Class<T> responseClass) {
        try {
            String payload = request.getPayload();
            String uri = request.getUri();

            String response = banxaClient.request(request.getMethod(), uri, payload);

            System.out.println(response); // TODO Remove

            return buildResponse(responseClass, response);
        } catch (Exception e) {
            e.printStackTrace();
            return new BanxaResponse<>(false, null, null);
        }
    }

    private static <T> BanxaResponse<T> buildResponse(Class<T> responseClass, String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setLocale(Locale.US);
        mapper.registerModule(new JavaTimeModule());
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // To ensure this can be converted from JSON properly we need to strip out the data and meta nodes
        JsonNode root = mapper.readTree(response);
        String content = mapper.writeValueAsString(root.findValue("data"));

        JsonNode metaNode = root.findValue("meta");
        Pagination pagination = null;
        if (metaNode != null) {
            String metaText = mapper.writeValueAsString(metaNode);
            pagination = mapper.readValue(metaText, Pagination.class);
        }

        return new BanxaResponse<>(true, mapper.readValue(content, responseClass), pagination);
    }
}
