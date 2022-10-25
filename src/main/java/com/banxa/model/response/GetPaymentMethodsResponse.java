package com.banxa.model.response;

import com.banxa.model.PaymentMethod;

import java.util.List;

public class GetPaymentMethodsResponse {
    private List<PaymentMethod> paymentMethods;

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }
}
