package com.afm.controller;

import com.afm.Pojo;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@Controller("/")
public class DefaultController {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultController.class);

    @Get(produces = MediaType.TEXT_HTML)
    public ModelAndView index() {
        return new ModelAndView("index", CollectionUtils.mapOf());
    }

    @Get(uri = "getMessage", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> getMessage() {

        return HttpResponse.ok(CollectionUtils.mapOf("status", "200", "message", "Hello World"));
    }

    @Post(uri = "postPojo", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> postPojo(Pojo request) {
        LOG.info("Received JSON: {}", request.getValue());
        return HttpResponse.ok(CollectionUtils.mapOf("status", "200"));
    }

}