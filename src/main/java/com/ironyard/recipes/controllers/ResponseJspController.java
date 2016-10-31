package com.ironyard.recipes.controllers;

import com.ironyard.recipes.dto.Response;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by favianalopez on 10/30/16.
 */

@Controller
public class ResponseJspController {

        @RequestMapping(value = "/jsp/recipe", method = RequestMethod.GET)
        public String list(Map<String, Object> model){
            RestTemplate restTemplate = new RestTemplate();
            // work around to fix broken api
            restTemplate.getInterceptors().add((request, body, execution) -> {
                ClientHttpResponse response = execution.execute(request,body);
                response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                return response;
            });
            Response response = restTemplate.getForObject("http://www.recipepuppy.com/api/", Response.class);

            model.put("recipes", response.getResults());
            return "recipes-list";
        }

    }

