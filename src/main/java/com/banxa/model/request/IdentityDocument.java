package com.banxa.model.request;

import com.banxa.model.IdentityDocumentType;

import java.util.ArrayList;
import java.util.List;

public class IdentityDocument {
    private final IdentityDocumentType type;
    private final List<IdentityDocumentImage> images;
    private final IdentityDocumentData data;

    public IdentityDocument(Builder builder) {
        this.type = builder.type;
        this.images = builder.images;
        this.data = builder.data;
    }

    public IdentityDocumentType getType() {
        return type;
    }

    public List<IdentityDocumentImage> getImages() {
        return images;
    }

    public IdentityDocumentData getData() {
        return data;
    }

    public static class Builder {
        private final IdentityDocumentType type;
        private List<IdentityDocumentImage> images;
        private IdentityDocumentData data;

        public Builder(IdentityDocumentType type) {
            this.type = type;
        }

        public Builder addImage(IdentityDocumentImage image) {
            if (images == null) {
                images = new ArrayList<>();
            }
            images.add(image);
            return this;
        }

        public Builder withData(IdentityDocumentData data) {
            this.data = data;
            return this;
        }

        public IdentityDocument build() {
            return new IdentityDocument(this);
        }
    }
}
