package com.odhekar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DefaultController {

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @View("home")
    @Get
    public HttpResponse<Map<String, Object>> getAuthenticatedView(HttpRequest<?> request,
                                                                  @Nullable Authentication authentication) {
        Map<String, Object> responseMap = new HashMap<>();
        if (authentication != null) {
            responseMap.put("name", authentication.getName());
            responseMap.put("email", authentication.getAttributes().get("email"));
        }
        if (request.getHeaders().get(HttpHeaders.AUTHORIZATION) != null) {
            responseMap.put("token", getToken(request));
            responseMap.put("decodedToken", getDecodedToken(request));
        }
        responseMap.put("headers", getHeaders(request));
        return HttpResponse.ok(responseMap);
    }

    private String getHeaders(HttpRequest<?> request) {
        HashMap<String, String> headers = new HashMap<>();
        request.getHeaders().asMap().forEach((s, strings) -> headers.put(s, strings.get(0)));
        try {
            return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(headers);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    private String getToken(HttpRequest<?> request) {
        return request.getHeaders().get(HttpHeaders.AUTHORIZATION).split("Bearer ")[1];
    }

    private String getDecodedToken(HttpRequest<?> request) {
        String[] tokenParts = getToken(request).split("\\.");
        byte[] token = Base64.getDecoder().decode(tokenParts[1]);
        JsonNode jwt = null;
        try {
            jwt = new ObjectMapper().readTree(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .writeValueAsString(jwt);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }


}
