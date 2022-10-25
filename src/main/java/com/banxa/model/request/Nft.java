package com.banxa.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nft {
    private final String name;
    private final String collection;
    private final NftMedia media;
    private Nft(Builder builder) {
        this.name = builder.name;
        this.collection = builder.collection;
        this.media = builder.media;
    }

    public String getName() {
        return name;
    }

    public String getCollection() {
        return collection;
    }

    public NftMedia getMedia() {
        return media;
    }

    public static class Builder {
        private final String name;
        private final String collection;
        private final NftMedia media;

        public Builder(String name, String collection, NftMedia media) {
            this.name = name;
            this.collection = collection;
            this.media = media;
        }

        public Nft build() {
            return new Nft(this);
        }
    }

}
