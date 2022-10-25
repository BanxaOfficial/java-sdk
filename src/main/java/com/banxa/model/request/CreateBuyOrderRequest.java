package com.banxa.model.request;

public class CreateBuyOrderRequest extends CreateOrderRequest {
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

    public static class Builder extends CreateOrderRequest.Builder<Builder> {
        private final String walletAddress;
        private String walletAddressTag;

        public Builder(String accountReference, String source, String target, String walletAddress, String returnUrlOnSuccess) {
            super(accountReference, source, target, returnUrlOnSuccess);
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
