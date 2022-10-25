package com.banxa.model.request;

import com.banxa.model.OrderType;

public class GetFiatCurrenciesRequest extends GetRequest {

    private final OrderType orderType;

    private GetFiatCurrenciesRequest(Builder builder) {
        this.orderType = builder.orderType;
    }

    public GetFiatCurrenciesRequest(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    @Override
    public String getUri() {
        return "/api/fiats/" + orderType.getType();
    }

    public static class Builder {
        private final OrderType orderType;

        public Builder(OrderType orderType) {
            this.orderType = orderType;
        }

        public GetFiatCurrenciesRequest build() {
            return new GetFiatCurrenciesRequest(this);
        }
    }
}
