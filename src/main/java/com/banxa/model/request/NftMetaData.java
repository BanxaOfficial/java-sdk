package com.banxa.model.request;

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
