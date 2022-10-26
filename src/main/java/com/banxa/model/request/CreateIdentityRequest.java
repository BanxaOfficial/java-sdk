package com.banxa.model.request;

import com.banxa.model.response.CreateIdentityResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class CreateIdentityRequest extends PostRequest<CreateIdentityResponse> {

    private final String accountReference;
    private final String mobileNumber;
    private final String email;
    private final CustomerIdentity customerIdentity;
    private final List<IdentityDocument> identityDocuments;
    private final String identitySharing;

    private CreateIdentityRequest(Builder builder) {
        this.accountReference = builder.accountReference;
        this.mobileNumber = builder.mobileNumber;
        this.email = builder.email;
        this.customerIdentity = builder.customerIdentity;
        this.identityDocuments = builder.identityDocuments;
        this.identitySharing = builder.identitySharing;
    }

    public CreateIdentityRequest(String accountReference, String mobileNumber, String email, CustomerIdentity customerIdentity, List<IdentityDocument> identityDocuments, String identitySharing) {
        this.accountReference = accountReference;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.customerIdentity = customerIdentity;
        this.identityDocuments = identityDocuments;
        this.identitySharing = identitySharing;
    }

    @Override
    public Class<CreateIdentityResponse> getResponseClass() {
        return CreateIdentityResponse.class;
    }

    @Override
    @JsonIgnore
    public String getUri() {
        return "/api/identities";
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public CustomerIdentity getCustomerIdentity() {
        return customerIdentity;
    }

    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    public String getIdentitySharing() {
        return identitySharing;
    }

    public static class Builder {
        private final String accountReference;
        private final String mobileNumber;
        private final String email;
        private CustomerIdentity customerIdentity;
        private List<IdentityDocument> identityDocuments;
        private String identitySharing;

        public Builder(String accountReference, String mobileNumber, String email) {
            this.accountReference = accountReference;
            this.mobileNumber = mobileNumber;
            this.email = email;
        }

        public Builder withCustomerIdentity(CustomerIdentity customerIdentity) {
            this.customerIdentity = customerIdentity;
            return this;
        }

        public Builder addIdentityDocuments(IdentityDocument identityDocument) {
            if (identityDocuments == null) {
                identityDocuments = new ArrayList<>();
            }
            identityDocuments.add(identityDocument);
            return this;
        }

        public Builder withIdentitySharing(String identitySharing) {
            this.identitySharing = identitySharing;
            return this;
        }

        public CreateIdentityRequest build() {
            return new CreateIdentityRequest(this);
        }
    }
}
