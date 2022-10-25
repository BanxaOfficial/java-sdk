package com.banxa.model;

import java.util.Objects;

public class TransactionLimit {
    private String fiatCode;
    private Double min;
    private Double max;

    public TransactionLimit() {
    }

    public TransactionLimit(String fiatCode, Double min, Double max) {
        this.fiatCode = fiatCode;
        this.min = min;
        this.max = max;
    }

    public String getFiatCode() {
        return fiatCode;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionLimit that = (TransactionLimit) o;
        return Objects.equals(getFiatCode(), that.getFiatCode()) && Objects.equals(getMin(), that.getMin()) && Objects.equals(getMax(), that.getMax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFiatCode(), getMin(), getMax());
    }
}
