package com.banxa.model.request;

public abstract class PaginatedGetRequest<T> extends GetRequest<T> {
    private final Integer perPage;
    private Integer page;

    public PaginatedGetRequest(Builder<?> builder) {
        this.perPage = builder.perPage;
        this.page = builder.page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void nextPage() {
        page = page + 1;
    }

    public void previousPage() {
        page = page - 1;
    }

    public static abstract class Builder <T extends Builder<T>> {
        private Integer perPage;
        private Integer page = 1;

        public Builder() {
        }

        public T withPerPage(Integer perPage) {
            this.perPage = perPage;
            return (T) this;
        }

        public T withPage(Integer page) {
            this.page = page;
            return (T) this;
        }
    }
}
