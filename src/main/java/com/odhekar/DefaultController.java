package com.odhekar;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class DefaultController {

    private static final Logger log = LoggerFactory.getLogger(DefaultController.class);

    @Get
    @Produces(MediaType.TEXT_HTML)
    public String getDefault(HttpRequest<?> request) {
        var response = "<html><style>body {font-family: sans-serif;}</style><body>";
        if (request.getHeaders().get(HttpHeaders.AUTHORIZATION) != null) {
            var rawJwt = request.getHeaders().get(HttpHeaders.AUTHORIZATION).split("Bearer ")[1];
            var jwt = new TokenPojo(rawJwt);
            response += "<h2>Decoded JWT</h2><pre>" + jwt.toString() + "</pre><hr>";
        }
        response += "<h2>Headers</h2><pre>";
        response += new HeaderPojo(request).toString();
        response += "</pre></body></html>";
        log.info(response);
        return response;
    }


}
