package com.banxa.model.request;

public class CreateOrderRequestOptions {
    private final boolean readonlyAmounts;

    public CreateOrderRequestOptions(boolean readonlyAmounts) {
        this.readonlyAmounts = readonlyAmounts;
    }

    public boolean isReadonlyAmounts() {
        return readonlyAmounts;
    }
}
