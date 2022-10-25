package com.banxa.model;

public enum OrderType {
    BUY("buy"),
    SELL("sell");

    private final String type;

    OrderType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
