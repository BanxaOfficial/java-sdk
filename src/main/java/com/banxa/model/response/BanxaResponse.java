package com.banxa.model.response;

public class BanxaResponse <T> {
    private final boolean success;
    private T response;
    private ErrorResponse errorResponse;
    private Pagination pagination;

    public BanxaResponse(T response, Pagination pagination) {
        this.success = true;
        this.response = response;
        this.pagination = pagination;
    }

    public BanxaResponse(ErrorResponse errorResponse) {
        this.success = false;
        this.errorResponse = errorResponse;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
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
