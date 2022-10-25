package com.banxa.model.request;

public class NftMedia {
    private final String type;
    private final String link;
    private NftMedia(Builder builder) {
        this.type = builder.type;
        this.link = builder.link;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public static class Builder {
        private final String type;
        private final String link;

        public Builder(String type, String link) {
            this.type = type;
            this.link = link;
        }

        public NftMedia build() {
            return new NftMedia(this);
        }
    }
}
