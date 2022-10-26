package com.banxa.model.request;

import com.banxa.model.response.ConfirmSellOrderResponse;

public class ConfirmSellOrderRequest extends PostRequest<ConfirmSellOrderResponse> {
    @Override
    public String getUri() {
        return null;
    }

    @Override
    public Class<ConfirmSellOrderResponse> getResponseClass() {
        return ConfirmSellOrderResponse.class;
    }
}
