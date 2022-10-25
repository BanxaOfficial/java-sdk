package com.banxa.model.response;

import java.util.Objects;

public class Pagination {
    private Integer currentPage;
    private Integer from;
    private Integer lastPage;
    private Integer perPage;
    private Integer to;
    private Integer total;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getTotal() {
        return total;
    }

    public boolean isLastPage() {
        return Objects.equals(currentPage, lastPage);
    }
}
