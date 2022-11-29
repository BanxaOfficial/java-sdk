package com.banxa.service;

import com.banxa.client.BanxaClient;
import com.banxa.client.BanxaClientResponse;
import com.banxa.exception.BanxaException;
import com.banxa.exception.InvalidResponseException;
import com.banxa.model.request.*;
import com.banxa.model.response.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    @Override
    public GetFiatCurrenciesResponse getFiatCurrencies(GetFiatCurrenciesRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetCryptoCurrenciesResponse getCryptoCurrencies(GetCryptoCurrenciesRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetCountriesResponse getCountries(GetCountriesRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetUsStatesResponse getUsStates(GetUsStatesRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetPaymentMethodsResponse getPaymentMethods(GetPaymentMethodsRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetPricesResponse getPrices(GetPricesRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public CreateBuyOrderResponse createBuyOrder(CreateBuyOrderRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public CreateSellOrderResponse createSellOrder(CreateSellOrderRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public CreateNftOrderResponse createNftOrder(CreateNftOrderRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public ConfirmSellOrderResponse confirmSellOrder(ConfirmSellOrderRequest request) throws BanxaException {
        return request(request);
    }

    @Override
    public CreateIdentityResponse createIdentity(CreateIdentityRequest request) throws BanxaException {
        return request(request);
    }

    public <T> T request(Request<T> request) throws BanxaException {
        try {
            String payload = request.getPayload();
            String uri = request.getUri();

            BanxaClientResponse response = banxaClient.request(request.getMethod(), uri, payload);

            if (response.isSuccessful()) {
                return buildResponse(request.getResponseClass(), response.getBody());
            } else {
                throw new BanxaException(response.getCode() + ": " + response.getBody());
            }
        } catch(Exception e) {
            throw new BanxaException(ErrorResponse.DEFAULT_ERROR_STATUS_CODE + ": " + e.getMessage());
        }
    }

    private static <T> T buildResponse(Class<T> responseClass, String response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setLocale(Locale.US);
        mapper.registerModule(new JavaTimeModule());
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            // To ensure this can be converted from JSON properly we need to strip out the data and meta nodes
            JsonNode root = mapper.readTree(response);
            ObjectNode dataNode = (ObjectNode) root.findValue("data");

            JsonNode metaNode = root.findValue("meta");
            dataNode.putIfAbsent("pagination", metaNode);

            return mapper.readValue(mapper.writeValueAsString(dataNode), responseClass);
        } catch (Exception e) {
            throw new InvalidResponseException(e);
        }
    }
}
