package com.banxa.model.request;

public class CreateSellOrderRequest extends CreateOrderRequest {

    private final String refundAddress;
    private final String refundAddressTag;
    private final String sourceAddress;
    private final String sourceAddressTag;

    private CreateSellOrderRequest(Builder builder) {
        super(builder);
        this.refundAddress = builder.refundAddress;
        this.refundAddressTag = builder.refundAddressTag;
        this.sourceAddress = builder.sourceAddress;
        this.sourceAddressTag = builder.sourceAddressTag;
    }

    public String getRefundAddress() {
        return refundAddress;
    }

    public String getRefundAddressTag() {
        return refundAddressTag;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getSourceAddressTag() {
        return sourceAddressTag;
    }

    public static class Builder extends CreateOrderRequest.Builder<Builder> {
        private final String refundAddress;
        private String refundAddressTag;
        private String sourceAddress;
        private String sourceAddressTag;

        public Builder(String accountReference, String source, String target, String refundAddress, String returnUrlOnSuccess) {
            super(accountReference, source, target, returnUrlOnSuccess);
            this.refundAddress = refundAddress;
        }

        public Builder withRefundAddressTag(String refundAddressTag) {
            this.refundAddressTag = refundAddressTag;
            return this;
        }

        public Builder withSourceAddress(String sourceAddress) {
            this.sourceAddress = sourceAddress;
            return this;
        }

        public Builder withSourceAddressTag(String sourceAddressTag) {
            this.sourceAddressTag = sourceAddressTag;
            return this;
        }

        public CreateSellOrderRequest build() {
            return new CreateSellOrderRequest(this);
        }
    }
}
