package com.banxa.model.request;

public class GetUsStatesRequest extends GetRequest {

    private GetUsStatesRequest(Builder builder) {

    }

    public GetUsStatesRequest() {
    }

    @Override
    public String getUri() {
        return "/api/countries/us/states";
    }

    public static class Builder {

        public Builder() {

        }

        public GetUsStatesRequest build() {
            return new GetUsStatesRequest(this);
        }
    }
}
