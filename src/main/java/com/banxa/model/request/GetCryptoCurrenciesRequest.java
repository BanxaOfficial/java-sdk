package com.banxa.model.request;

import com.banxa.model.OrderType;
import com.banxa.model.response.GetCryptoCurrenciesResponse;

public class GetCryptoCurrenciesRequest extends GetRequest<GetCryptoCurrenciesResponse> {
    private final OrderType orderType;

    private GetCryptoCurrenciesRequest(Builder builder) {
        this.orderType = builder.orderType;
    }

    public GetCryptoCurrenciesRequest(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    @Override
    public String getUri() {
        return "/api/coins/" + orderType.getType();
    }

    @Override
    public Class<GetCryptoCurrenciesResponse> getResponseClass() {
        return GetCryptoCurrenciesResponse.class;
    }

    public static class Builder {
        private final OrderType orderType;

        public Builder(OrderType orderType) {
            this.orderType = orderType;
        }

        public GetCryptoCurrenciesRequest build() {
            return new GetCryptoCurrenciesRequest(this);
        }
    }}
