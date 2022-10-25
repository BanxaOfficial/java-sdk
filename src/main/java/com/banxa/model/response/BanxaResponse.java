package com.banxa.model.response;

public class BanxaResponse <T> {
    private final boolean success;
    private final T response;
    private final Pagination pagination;

    public BanxaResponse(boolean success, T response, Pagination pagination) {
        this.success = success;
        this.response = response;
        this.pagination = pagination;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }

    public Pagination getPagination() {
        return pagination;
    }

    /**
     * This is the last page either if there is no pagination for this response or
     * the last page has been reached for this paginated response
     * @return true | false
     */
    public boolean isLastPage() {
        return pagination == null || pagination.isLastPage();
    }
}
