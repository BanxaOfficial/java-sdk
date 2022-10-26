package com.banxa.model.request;

import java.util.Map;

public abstract class GetRequest<T> implements Request<T> {
    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public String getPayload() {
        return null;
    }

    protected void addUriParam(Map<String, String> params, String key, String value) {
        if (value != null) {
            params.put(key, value);
        }
    }

    protected void addUriParam(Map<String, String> params, String key, Double value) {
        if (value != null) {
            params.put(key, value.toString());
        }
    }
    
    protected void addUriParam(Map<String, String> params, String key, Integer value) {
        if (value != null) {
            params.put(key, value.toString());
        }
    }

    protected String appendUriParams(String uri, Map<String, String> params) {
        String appender = "?";
        StringBuilder uriBuilder = new StringBuilder(uri);
        for (Map.Entry<String, String> param : params.entrySet()) {
            uriBuilder.append(appender).append(param.getKey()).append("=").append(param.getValue());
            appender = "&";
        }
        return uriBuilder.toString();
    }

}
