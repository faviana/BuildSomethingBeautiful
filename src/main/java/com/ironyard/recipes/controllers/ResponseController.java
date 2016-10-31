package com.ironyard.recipes.controllers;

import com.ironyard.recipes.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by favianalopez on 10/28/16.
 */
@RestController
public class ResponseController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/recipe", method = RequestMethod.GET, produces = "application/json")

    public Iterable<Response> listOfResponse(@RequestParam(value = "filter", required = false) String filter) {

        log.debug("Request to list.");
        RestTemplate restTemplate = new RestTemplate();
        // work around to fix broken api
        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
        // normal code
        Response response = restTemplate.getForObject("http://www.recipepuppy.com/api", Response.class);
        log.info(response.toString());
        log.debug("Get Response");
        List<Response> foundAllList = Arrays.asList(response);

        return foundAllList;

    }
}


