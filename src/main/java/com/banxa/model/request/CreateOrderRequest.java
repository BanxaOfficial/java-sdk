package com.banxa.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class CreateOrderRequest<T> extends PostRequest<T> {
    private String accountReference;
    private Integer paymentMethodId;
    private String source;
    private String sourceAmount;
    private String target;
    private String targetAmount;
    private String blockchain;
    private String returnUrlOnSuccess;
    private String returnUrlOnCancelled;
    private String returnUrlOnFailure;
    private String iframeDomain;
    private MetaData metaData;
    private CreateOrderRequestOptions options;
    private String email;
    private String mobile;

    protected CreateOrderRequest(Builder<?> builder) {
        this.accountReference = builder.accountReference;
        this.paymentMethodId = builder.paymentMethodId;
        this.source = builder.source;
        this.sourceAmount = builder.sourceAmount;
        this.target = builder.target;
        this.targetAmount = builder.targetAmount;
        this.blockchain = builder.blockchain;
        this.returnUrlOnSuccess = builder.returnUrlOnSuccess;
        this.returnUrlOnCancelled = builder.returnUrlOnCancelled;
        this.returnUrlOnFailure = builder.returnUrlOnFailure;
        this.iframeDomain = builder.iframeDomain;
        this.metaData = builder.metaData;
        this.options = builder.options;
        this.email = builder.email;
        this.mobile = builder.mobile;
    }

    @Override
    @JsonIgnore
    public String getUri() {
        return "/api/orders";
    }

    public String getAccountReference() {
        return accountReference;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getSource() {
        return source;
    }

    public String getSourceAmount() {
        return sourceAmount;
    }

    public String getTarget() {
        return target;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public String getBlockchain() {
        return blockchain;
    }

    public String getReturnUrlOnSuccess() {
        return returnUrlOnSuccess;
    }

    public String getReturnUrlOnCancelled() {
        return returnUrlOnCancelled;
    }

    public String getReturnUrlOnFailure() {
        return returnUrlOnFailure;
    }

    public String getIframeDomain() {
        return iframeDomain;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public CreateOrderRequestOptions getOptions() {
        return options;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public static abstract class Builder <T extends Builder<T>> {
        private String accountReference;
        private Integer paymentMethodId;
        private String source;
        private String sourceAmount;
        private String target;
        private String targetAmount;
        private String blockchain;
        private String returnUrlOnSuccess;
        private String returnUrlOnCancelled;
        private String returnUrlOnFailure;
        private String iframeDomain;
        private MetaData metaData;
        private CreateOrderRequestOptions options;
        private String email;
        private String mobile;

        public Builder(String accountReference, String source, String target, String returnUrlOnSuccess) {
            this.accountReference = accountReference;
            this.source = source;
            this.target = target;
            this.returnUrlOnSuccess = returnUrlOnSuccess;
        }

        public T withPaymentMethodId(Integer paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return (T) this;
        }

        public T withSourceAmount(String sourceAmount) {
            this.sourceAmount = sourceAmount;
            return (T) this;
        }

        public T withTargetAmount(String targetAmount) {
            this.targetAmount = targetAmount;
            return (T) this;
        }

        public T withBlockchain(String blockchain) {
            this.blockchain = blockchain;
            return (T) this;
        }

        public T withReturnUrlOnCancelled(String returnUrlOnCancelled) {
            this.returnUrlOnCancelled = returnUrlOnCancelled;
            return (T) this;
        }

        public T withReturnUrlOnFailure(String returnUrlOnFailure) {
            this.returnUrlOnFailure = returnUrlOnFailure;
            return (T) this;
        }

        public T withIframeDomain(String iframeDomain) {
            this.iframeDomain = iframeDomain;
            return (T) this;
        }

        public T withMetaData(MetaData metaData) {
            this.metaData = metaData;
            return (T) this;
        }

        public T withOptions(CreateOrderRequestOptions options) {
            this.options = options;
            return (T) this;
        }

        public T withEmail(String email) {
            this.email = email;
            return (T) this;
        }

        public T withMobile(String mobile) {
            this.mobile = mobile;
            return (T) this;
        }
    }
}
