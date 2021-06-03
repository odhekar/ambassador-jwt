package com.odhekar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;


@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class DefaultController {

    @Get
    @Produces(MediaType.TEXT_HTML)
    public String getDefault(HttpRequest<?> request) {
        var response = "<html><style>body {font-family: sans-serif;}</style><body>";
        if (request.getHeaders().get(HttpHeaders.AUTHORIZATION) != null) {
            response += "<b>Decoded JWT</b><pre>" + getDecodedToken(request) + "</pre><hr>";
        }
        response += "<b>Request Headers</b><pre>" + getHeaders(request) + "</pre></body></html>";
        return response;
    }

    private String getHeaders(HttpRequest<?> request) {
        HashMap<String, String> headers = new HashMap<>();
        request.getHeaders().asMap().forEach((s, strings) -> {
            headers.put(s, strings.get(0));
        });
        try {
            return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(headers);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    private String getDecodedToken(HttpRequest<?> request) {
        String token = request.getHeaders().get(HttpHeaders.AUTHORIZATION).split("Bearer ")[1];
        String[] tokenParts = token.split("\\.");
        JsonNode jwt = null;
        try {
            jwt = new ObjectMapper()
                .readTree(Base64.getDecoder().decode(tokenParts[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prettyJson(jwt);
    }

    private String prettyJson(JsonNode node) {
        try {
            return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .writeValueAsString(node);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

}
