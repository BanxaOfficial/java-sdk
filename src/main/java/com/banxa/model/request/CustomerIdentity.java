package com.banxa.model.request;

public class CustomerIdentity {

    private final String givenName;
    private final String surname;
    private final String dob;
    private final ResidentialAddress residentialAddress;

    private CustomerIdentity(Builder builder) {
        this.givenName = builder.givenName;
        this.surname = builder.surname;
        this.dob = builder.dob;
        this.residentialAddress = builder.residentialAddress;
    }

    public CustomerIdentity(String givenName, String surname, String dob, ResidentialAddress residentialAddress) {
        this.givenName = givenName;
        this.surname = surname;
        this.dob = dob;
        this.residentialAddress = residentialAddress;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob() {
        return dob;
    }

    public ResidentialAddress getResidentialAddress() {
        return residentialAddress;
    }

    public static class Builder {
        private final String givenName;
        private final String surname;
        private String dob;
        private final ResidentialAddress residentialAddress;

        public Builder(String givenName, String surname, ResidentialAddress residentialAddress) {
            this.givenName = givenName;
            this.surname = surname;
            this.residentialAddress = residentialAddress;
        }

        public Builder withDob(String dob) {
            this.dob = dob;
            return this;
        }

        public CustomerIdentity build() {
            return new CustomerIdentity(this);
        }
    }
}
