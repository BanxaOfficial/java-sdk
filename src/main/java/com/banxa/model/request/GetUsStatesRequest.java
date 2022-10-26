package com.banxa.model.request;

import com.banxa.model.response.GetUsStatesResponse;

public class GetUsStatesRequest extends GetRequest<GetUsStatesResponse> {

    private GetUsStatesRequest(Builder builder) {

    }

    public GetUsStatesRequest() {
    }

    @Override
    public String getUri() {
        return "/api/countries/us/states";
    }

    @Override
    public Class<GetUsStatesResponse> getResponseClass() {
        return GetUsStatesResponse.class;
    }

    public static class Builder {

        public Builder() {

        }

        public GetUsStatesRequest build() {
            return new GetUsStatesRequest(this);
        }
    }
}
