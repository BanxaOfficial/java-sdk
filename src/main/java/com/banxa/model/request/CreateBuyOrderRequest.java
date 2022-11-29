package com.banxa.model.request;

import com.banxa.model.response.CreateBuyOrderResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CreateBuyOrderRequest extends CreateOrderRequest<CreateBuyOrderResponse> {
    private final String walletAddress;
    private String walletAddressTag;

    private CreateBuyOrderRequest(Builder builder) {
        super(builder);
        this.walletAddress = builder.walletAddress;
        this.walletAddressTag = builder.walletAddressTag;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getWalletAddressTag() {
        return walletAddressTag;
    }

    @Override
    @JsonIgnore
    public Class<CreateBuyOrderResponse> getResponseClass() {
        return CreateBuyOrderResponse.class;
    }

    public static class Builder extends CreateOrderRequest.Builder<Builder> {
        private final String walletAddress;
        private String walletAddressTag;

        public Builder(String accountReference, String fiatCode, String coinCode, String walletAddress, String returnUrlOnSuccess) {
            super(accountReference, fiatCode, coinCode, returnUrlOnSuccess);
            this.walletAddress = walletAddress;
        }

        public Builder withWalletAddressTag(String walletAddressTag) {
            this.walletAddressTag = walletAddressTag;
            return this;
        }

        public CreateBuyOrderRequest build() {
            return new CreateBuyOrderRequest(this);
        }
    }
}
