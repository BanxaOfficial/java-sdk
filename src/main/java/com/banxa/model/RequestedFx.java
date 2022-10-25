package com.banxa.model;

public class RequestedFx {
    private String currency;
    private Double rate;
    private Double amount;
    private Double merchantFee;

    public String getCurrency() {
        return currency;
    }

    public Double getRate() {
        return rate;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getMerchantFee() {
        return merchantFee;
    }
}
