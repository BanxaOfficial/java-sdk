package com.banxa.model.request;

public class IdentitySharing {
    private final String provider;
    private final String token;

    public IdentitySharing(Builder builder) {
        this.provider = builder.provider;
        this.token = builder.token;
    }

    public String getProvider() {
        return provider;
    }

    public String getToken() {
        return token;
    }

    public static class Builder {
        private final String provider;
        private final String token;

        public Builder(String provider, String token) {
            this.provider = provider;
            this.token = token;
        }

        public IdentitySharing build() {
            return new IdentitySharing(this);
        }
    }

}
