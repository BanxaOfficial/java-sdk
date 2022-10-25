package com.banxa.model.request;

public class GetCountriesRequest extends GetRequest {

    private GetCountriesRequest(GetCountriesRequest.Builder builder) {

    }

    public GetCountriesRequest() {
    }

    @Override
    public String getUri() {
        return "/api/countries";
    }

    public static class Builder {

        public Builder() {

        }

        public GetCountriesRequest build() {
            return new GetCountriesRequest(this);
        }
    }
}
