package com.banxa.model;

public enum OrderStatus {
    PENDING_PAYMENT("pendingPayment"),
    WAITING_PAYMENT("waitingPayment"),
    PAYMENT_RECEIVED("paymentReceived"),
    IN_PROGRESS("inProgress"),
    COIN_TRANSFERRED("coinTransferred"),
    CANCELLED("cancelled"),
    DECLINED("declined"),
    EXPIRED("expired"),
    COMPLETE("complete"),
    REFUNDED("refunded");

    private final String status;

    private OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
