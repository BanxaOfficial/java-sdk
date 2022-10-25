package com.banxa.model.request;

public class IdentityDocumentImage {
    private final String link;

    private IdentityDocumentImage(Builder builder) {
        this.link = builder.link;
    }

    public IdentityDocumentImage(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public static class Builder {
        private final String link;

        public Builder(String link) {
            this.link = link;
        }

        public IdentityDocumentImage build() {
            return new IdentityDocumentImage(this);
        }
    }
}
