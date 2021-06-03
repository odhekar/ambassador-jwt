package com.odhekar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.micronaut.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class HeaderPojo {
    Map<String, String> headers;

    public HeaderPojo(HttpRequest<?> request) {
        this.headers = new HashMap<>();
        request.getHeaders().asMap().forEach((s, strings) -> {
            this.headers.put(s, strings.get(0));
        });
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String toString() {
        try {
            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}