package com.rest.api.response;

import java.util.HashMap;
import java.util.Map;

public class ResponseMap extends ApiResponse {
    private Map responseData = new HashMap<>();

    public ResponseMap() {
        setResult(responseData);
    }

    public void setResponseData(String key, Object value) {
        this.responseData.put(key, value);
    }
}
