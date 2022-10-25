package com.banxa.model.request;

public class IdentityDocumentData {
    private final String number;

    private IdentityDocumentData(Builder builder) {
        this.number = builder.number;
    }

    public IdentityDocumentData(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public static class Builder {
        private final String number;

        public Builder(String number) {
            this.number = number;
        }

        public IdentityDocumentData build() {
            return new IdentityDocumentData(this);
        }
    }
}
