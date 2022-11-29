package com.banxa.model.request;

import com.banxa.model.OrderType;
import com.banxa.model.response.GetFiatCurrenciesResponse;

public class GetFiatCurrenciesRequest extends GetRequest<GetFiatCurrenciesResponse> {

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

    @Override
    public Class<GetFiatCurrenciesResponse> getResponseClass() {
        return GetFiatCurrenciesResponse.class;
    }

    public static Builder createBuyBuilder() {
        return new Builder(OrderType.BUY);
    }

    public static Builder createSellBuilder() {
        return new Builder(OrderType.SELL);
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
