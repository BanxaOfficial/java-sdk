package com.banxa.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

public abstract class PostRequest<T> implements Request<T> {

    @Override
    @JsonIgnore
    public String getMethod() {
        return "POST";
    }

    @Override
    @JsonIgnore
    public String getPayload() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(this);
    }
}
