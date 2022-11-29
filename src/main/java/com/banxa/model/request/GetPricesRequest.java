package com.banxa.model.request;

import com.banxa.model.response.GetPricesResponse;

import java.util.Map;
import java.util.TreeMap;

public class GetPricesRequest extends GetRequest<GetPricesResponse> {
    private static final String BASE_URI = "/api/prices";
    private final String source;
    private final Double sourceAmount;
    private final String target;
    private final Double targetAmount;
    private final Integer paymentMethodId;
    private final String accountReference;
    private final String blockchain;

    private GetPricesRequest(Builder builder) {
        this.source = builder.source;
        this.sourceAmount = builder.sourceAmount;
        this.target = builder.target;
        this.targetAmount = builder.targetAmount;
        this.paymentMethodId = builder.paymentMethodId;
        this.accountReference = builder.accountReference;
        this.blockchain = builder.blockchain;
    }

    @Override
    public String getUri() {
        Map<String, String> uriParams = new TreeMap<>();
        this.addUriParam(uriParams, "source", source);
        this.addUriParam(uriParams, "source_amount", sourceAmount);
        this.addUriParam(uriParams, "target", target);
        this.addUriParam(uriParams, "target_amount", targetAmount);
        this.addUriParam(uriParams, "payment_method_id", paymentMethodId);
        this.addUriParam(uriParams, "account_reference", accountReference);
        this.addUriParam(uriParams, "blockchain", blockchain);

        return appendUriParams(BASE_URI, uriParams);
    }

    @Override
    public Class<GetPricesResponse> getResponseClass() {
        return GetPricesResponse.class;
    }

    public static Builder createBuyBuilder(String fiatCode, String coinCode) {
        return new Builder(fiatCode, coinCode);
    }

    public static Builder createSellBuilder(String fiatCode, String coinCode) {
        return new Builder(coinCode, fiatCode);
    }

    public static class Builder {
        private final String source;
        private Double sourceAmount;
        private final String target;
        private Double targetAmount;
        private Integer paymentMethodId;
        private String accountReference;
        private String blockchain;

        public Builder(String source, String target) {
            this.source = source;
            this.target = target;
        }

        public Builder withSourceAmount(Double sourceAmount) {
            this.sourceAmount = sourceAmount;
            return this;
        }

        public Builder withTargetAmount(Double targetAmount) {
            this.targetAmount = targetAmount;
            return this;
        }

        public Builder withPaymentMethodId(Integer paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }

        public Builder withAccountReference(String accountReference) {
            this.accountReference = accountReference;
            return this;
        }

        public Builder withBlockchain(String blockchain) {
            this.blockchain = blockchain;
            return this;
        }

        public GetPricesRequest build() {
            return new GetPricesRequest(this);
        }
    }
}
