package com.banxa.model.request;

import com.banxa.model.response.CreateNftOrderResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    public String getUri() {
        return "/api/orders/nft/buy";
    }

    @Override
    @JsonIgnore
    public Class<CreateNftOrderResponse> getResponseClass() {
        return CreateNftOrderResponse.class;
    }

    public static class Builder extends CreateOrderRequest.Builder<Builder> {

        private final String walletAddress;

        public Builder(String accountReference, String fiatCode, String fiatAmount, String coinCode, String walletAddress, String returnUrlOnSuccess, NftMetaData metaData) {
            super(accountReference, fiatCode, coinCode, returnUrlOnSuccess);
            this.walletAddress = walletAddress;
            this.withSourceAmount(fiatAmount);
            this.withMetaData(metaData);
        }

        public CreateNftOrderRequest build() {
            return new CreateNftOrderRequest(this);
        }

    }
}
