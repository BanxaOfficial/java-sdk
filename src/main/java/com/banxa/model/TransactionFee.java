package com.banxa.model;

import java.util.List;
import java.util.Objects;

public class TransactionFee {
    private String fiatCode;
    private String coinCode;
    private List<Fee> fees;

    public TransactionFee() {
    }

    public TransactionFee(String fiatCode, String coinCode, List<Fee> fees) {
        this.fiatCode = fiatCode;
        this.coinCode = coinCode;
        this.fees = fees;
    }

    public String getFiatCode() {
        return fiatCode;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public List<Fee> getFees() {
        return fees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionFee that = (TransactionFee) o;
        return Objects.equals(getFiatCode(), that.getFiatCode()) && Objects.equals(getCoinCode(), that.getCoinCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFiatCode(), getCoinCode());
    }
}
