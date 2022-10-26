package com.banxa.model.request;

import com.banxa.model.response.GetOrderResponse;

import java.util.HashMap;
import java.util.Map;

public class GetOrderRequest extends GetRequest<GetOrderResponse> {
    private static final String BASE_URI = "/api/orders/";
    private final String orderId;
    private final String fxCurrency;

    private GetOrderRequest(Builder builder) {
        this.orderId = builder.orderId;
        this.fxCurrency = builder.fxCurrency;
    }

    @Override
    public String getUri() {
        String uri = BASE_URI + this.orderId;

        Map<String, String> uriParams = new HashMap<>();
        this.addUriParam(uriParams, "fx_currency", fxCurrency);

        return appendUriParams(uri, uriParams);
    }

    @Override
    public Class<GetOrderResponse> getResponseClass() {
        return GetOrderResponse.class;
    }

    public static class Builder {
        private final String orderId;
        private String fxCurrency;

        public Builder(String orderId) {
            this.orderId = orderId;
        }

        public Builder withFxCurrency(String fxCurrency) {
            this.fxCurrency = fxCurrency;
            return this;
        }

        public GetOrderRequest build() {
            return new GetOrderRequest(this);
        }
    }
}
