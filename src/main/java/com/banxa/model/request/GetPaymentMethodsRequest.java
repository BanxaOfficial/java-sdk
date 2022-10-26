package com.banxa.model.request;

import com.banxa.model.response.GetPaymentMethodsResponse;

import java.util.Map;
import java.util.TreeMap;

public class GetPaymentMethodsRequest extends GetRequest<GetPaymentMethodsResponse> {
    private static final String BASE_URI = "/api/payment-methods";
    private final String source;
    private final String target;

    private GetPaymentMethodsRequest(Builder builder) {
        this.source = builder.source;
        this.target = builder.target;
    }

    @Override
    public String getUri() {
        Map<String, String> uriParams = new TreeMap<>();
        this.addUriParam(uriParams, "source", source);
        this.addUriParam(uriParams, "target", target);

        return appendUriParams(BASE_URI, uriParams);
    }

    @Override
    public Class<GetPaymentMethodsResponse> getResponseClass() {
        return GetPaymentMethodsResponse.class;
    }

    public static class Builder {
        private String source;
        private String target;

        public Builder() {

        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Builder withTarget(String target) {
            this.target = target;
            return this;
        }

        public GetPaymentMethodsRequest build() {
            return new GetPaymentMethodsRequest(this);
        }
    }
}
