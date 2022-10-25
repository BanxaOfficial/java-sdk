package com.banxa.model;

import java.util.List;

public class PaymentMethod {
    private Integer id;
    private String name;
    private String description;
    private String logoUrl;
    private String status;
    private String type;
    private List<SupportedAgent> supportedAgents;
    private List<String> supportedFiat;
    private List<String> supportedCoin;
    private List<TransactionFee> transactionFees;
    private List<TransactionLimit> transactionLimits;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public List<SupportedAgent> getSupportedAgents() {
        return supportedAgents;
    }

    public List<String> getSupportedFiat() {
        return supportedFiat;
    }

    public List<String> getSupportedCoin() {
        return supportedCoin;
    }

    public List<TransactionFee> getTransactionFees() {
        return transactionFees;
    }

    public List<TransactionLimit> getTransactionLimits() {
        return transactionLimits;
    }
}
