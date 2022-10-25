package com.banxa.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private String id;
    private String accountId;
    private String accountReference;
    private String orderType;
    private String paymentType;
    private String ref;
    private String fiatCode;
    private Double fiatAmount;
    private String coinCode;
    private Double coinAmount;
    private String walletAddress;
    private String walletAddressTag;
    private Double fee;
    private Double feeTax;
    private Double paymentFee;
    private Double paymentFeeTax;
    private Double commission;
    private Double merchantFee;
    private Double merchantCommission;
    private String txHash;
    private String txConfirms;
    private Blockchain blockchain;
    private RequestedFx requestedFx;
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate createdDate;
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
    private LocalDateTime completedAt;
    private String status;
    private String checkoutUrl;
    private String metaData;

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getRef() {
        return ref;
    }

    public String getFiatCode() {
        return fiatCode;
    }

    public Double getFiatAmount() {
        return fiatAmount;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public Double getCoinAmount() {
        return coinAmount;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getWalletAddressTag() {
        return walletAddressTag;
    }

    public Double getFee() {
        return fee;
    }

    public Double getFeeTax() {
        return feeTax;
    }

    public Double getPaymentFee() {
        return paymentFee;
    }

    public Double getPaymentFeeTax() {
        return paymentFeeTax;
    }

    public Double getCommission() {
        return commission;
    }

    public Double getMerchantFee() {
        return merchantFee;
    }

    public Double getMerchantCommission() {
        return merchantCommission;
    }

    public String getTxHash() {
        return txHash;
    }

    public String getTxConfirms() {
        return txConfirms;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public String getStatus() {
        return status;
    }

    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public String getMetaData() {
        return metaData;
    }

    public RequestedFx getRequestedFx() {
        return requestedFx;
    }
}
