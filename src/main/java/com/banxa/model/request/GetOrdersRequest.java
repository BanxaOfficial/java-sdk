package com.banxa.model.request;

import com.banxa.model.OrderStatus;
import com.banxa.model.response.GetOrdersResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetOrdersRequest extends PaginatedGetRequest<GetOrdersResponse> {
    private static final String BASE_URI = "/api/orders";

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String status;
    private final String accountReference;

    private GetOrdersRequest(Builder builder) {
        super(builder);
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.status = builder.statuses.isEmpty() ? null : String.join(",", builder.statuses);
        this.accountReference = builder.accountReference;
    }

    @Override
    public String getUri() {
        Map<String, String> uriParams = new TreeMap<>();
        this.addUriParam(uriParams, "start_date", startDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        this.addUriParam(uriParams, "end_date", endDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        this.addUriParam(uriParams, "status", status);
        this.addUriParam(uriParams, "account_reference", accountReference);
        this.addUriParam(uriParams, "per_page", this.getPerPage());
        this.addUriParam(uriParams, "page", this.getPage());

        return appendUriParams(BASE_URI, uriParams);
    }

    @Override
    public Class<GetOrdersResponse> getResponseClass() {
        return GetOrdersResponse.class;
    }

    public static class Builder extends PaginatedGetRequest.Builder<Builder> {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final List<String> statuses = new ArrayList<>();
        private String accountReference;

        public Builder(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Builder addStatus(OrderStatus status) {
            this.statuses.add(status.getStatus());
            return this;
        }

        public Builder withAccountReference(String accountReference) {
            this.accountReference = accountReference;
            return this;
        }

        public GetOrdersRequest build() {
            return new GetOrdersRequest(this);
        }
    }

}
