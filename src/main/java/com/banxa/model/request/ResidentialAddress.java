package com.banxa.model.request;

public class ResidentialAddress {
    private final String addressLine1;
    private final String suburb;
    private final String postCode;
    private final String state;
    private final String country;

    private ResidentialAddress(Builder builder) {
        this.addressLine1 = builder.addressLine1;
        this.suburb = builder.suburb;
        this.postCode = builder.postCode;
        this.state = builder.state;
        this.country = builder.country;
    }

    public ResidentialAddress(String addressLine1, String suburb, String postCode, String state, String country) {
        this.addressLine1 = addressLine1;
        this.suburb = suburb;
        this.postCode = postCode;
        this.state = state;
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {
        private String addressLine1;
        private String suburb;
        private String postCode;
        private String state;
        private final String country;

        public Builder(String country) {
            this.country = country;
        }

        public Builder withAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder withSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder withPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder withState(String state) {
            this.state = state;
            return this;
        }

        public ResidentialAddress build() {
            return new ResidentialAddress(this);
        }
    }
}
