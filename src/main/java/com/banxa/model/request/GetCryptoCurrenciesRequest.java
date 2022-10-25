package com.banxa.model.request;

import com.banxa.model.OrderType;

public class GetCryptoCurrenciesRequest extends GetRequest {
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

    public static class Builder {
        private final OrderType orderType;

        public Builder(OrderType orderType) {
            this.orderType = orderType;
        }

        public GetCryptoCurrenciesRequest build() {
            return new GetCryptoCurrenciesRequest(this);
        }
    }}
