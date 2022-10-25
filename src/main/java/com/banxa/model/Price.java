package com.banxa.model;

public class Price {
    private Integer paymentMethodId;
    private String type;
    private String spotPriceFee;
    private String spotPriceIncludingFee;
    private String coinAmount;
    private String coinCode;
    private String fiatAmount;
    private String fiatCode;
    private String feeAmount;
    private String networkFee;

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getType() {
        return type;
    }

    public String getSpotPriceFee() {
        return spotPriceFee;
    }

    public String getSpotPriceIncludingFee() {
        return spotPriceIncludingFee;
    }

    public String getCoinAmount() {
        return coinAmount;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public String getFiatAmount() {
        return fiatAmount;
    }

    public String getFiatCode() {
        return fiatCode;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public String getNetworkFee() {
        return networkFee;
    }
}
