package com.banxa.model.request;

import com.banxa.model.response.CreateNftOrderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CreateNftOrderRequest extends CreateOrderRequest<CreateNftOrderResponse> {
    private final String walletAddress;
    protected CreateNftOrderRequest(Builder builder) {
        super(builder);
        this.walletAddress = builder.walletAddress;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    @Override
    public String getUri() {
        return "/api/orders/nft/buy";
    }

    @Override
    public Class<CreateNftOrderResponse> getResponseClass() {
        return CreateNftOrderResponse.class;
    }

    public static class Builder extends CreateOrderRequest.Builder<Builder> {

        private final String walletAddress;

        public Builder(String accountReference, String source, String sourceAmount, String target, String walletAddress, String returnUrlOnSuccess, NftMetaData metaData) throws JsonProcessingException {
            super(accountReference, source, target, returnUrlOnSuccess);
            this.walletAddress = walletAddress;
            this.withSourceAmount(sourceAmount);
            this.withMetaData(metaData);
        }

        public CreateNftOrderRequest build() {
            return new CreateNftOrderRequest(this);
        }

    }
}
