package com.banxa.model.request;

import com.banxa.model.response.ConfirmSellOrderResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ConfirmSellOrderRequest extends PostRequest<ConfirmSellOrderResponse> {
    private final String orderId;
    private final String txHash;
    private final String sourceAddress;
    private final String sourceAddressTag;
    private final String destinationAddress;
    private final String destinationAddressTag;

    private ConfirmSellOrderRequest(Builder builder) {
        this.orderId = builder.orderId;
        this.txHash = builder.txHash;
        this.sourceAddress = builder.sourceAddress;
        this.sourceAddressTag = builder.sourceAddressTag;
        this.destinationAddress = builder.destinationAddress;
        this.destinationAddressTag = builder.destinationAddressTag;
    }

    public String getTxHash() {
        return txHash;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getSourceAddressTag() {
        return sourceAddressTag;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getDestinationAddressTag() {
        return destinationAddressTag;
    }

    @Override
    @JsonIgnore
    public String getUri() {
        return "/api/orders/" + orderId + "/confirm";
    }

    @Override
    @JsonIgnore
    public Class<ConfirmSellOrderResponse> getResponseClass() {
        return ConfirmSellOrderResponse.class;
    }

    public static class Builder {
        private final String orderId;
        private final String txHash;
        private final String sourceAddress;
        private String sourceAddressTag;
        private final String destinationAddress;
        private String destinationAddressTag;

        public Builder(String orderId, String txHash, String sourceAddress, String destinationAddress) {
            this.orderId = orderId;
            this.txHash = txHash;
            this.sourceAddress = sourceAddress;
            this.destinationAddress = destinationAddress;
        }

        public Builder withSourceAddressTag(String sourceAddressTag) {
            this.sourceAddressTag = sourceAddressTag;
            return this;
        }

        public Builder withDestinationAddressTag(String destinationAddressTag) {
            this.destinationAddressTag = destinationAddressTag;
            return this;
        }

        public ConfirmSellOrderRequest build() {
            return new ConfirmSellOrderRequest(this);
        }
    }
}
