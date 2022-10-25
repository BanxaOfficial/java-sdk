package com.banxa.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NftMetaData implements MetaData {
    private final String purchaseReference;
    private final Nft nft;
    private NftMetaData(Builder builder) {
        this.purchaseReference = builder.purchaseReference;
        this.nft = builder.nft;
    }

    public String getPurchaseReference() {
        return purchaseReference;
    }

    public Nft getNft() {
        return nft;
    }

    public static class Builder {
        private final String purchaseReference;
        private final Nft nft;
        public Builder(String purchaseReference, Nft nft) {
            this.purchaseReference = purchaseReference;
            this.nft = nft;
        }

        public NftMetaData build() {
            return new NftMetaData(this);
        }
    }
}
