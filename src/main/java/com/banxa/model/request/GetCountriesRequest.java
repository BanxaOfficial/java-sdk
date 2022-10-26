package com.banxa.model.request;

import com.banxa.model.response.GetCountriesResponse;

public class GetCountriesRequest extends GetRequest<GetCountriesResponse> {

    private GetCountriesRequest(GetCountriesRequest.Builder builder) {

    }

    public GetCountriesRequest() {
    }

    @Override
    public String getUri() {
        return "/api/countries";
    }

    @Override
    public Class<GetCountriesResponse> getResponseClass() {
        return GetCountriesResponse.class;
    }

    public static class Builder {

        public Builder() {

        }

        public GetCountriesRequest build() {
            return new GetCountriesRequest(this);
        }
    }
}
