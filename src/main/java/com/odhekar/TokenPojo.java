package com.odhekar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Base64;

public class TokenPojo {
    private final JsonNode header;
    private final JsonNode payload;

    public TokenPojo(String token) {
        String[] tokenParts = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        ObjectMapper mapper = new ObjectMapper();
        this.header = getJsonNode(decoder.decode(tokenParts[0]));
        this.payload = getJsonNode(decoder.decode(tokenParts[1]));
    }

    public JsonNode getHeader() {
        return header;
    }

    public JsonNode getPayload() {
        return payload;
    }

    private JsonNode getJsonNode(byte[] raw) {
        try {
            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).readTree(raw);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        try {
            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

}
