package com.saptalabz.twitter_backend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TwitterApiConfiguration {

    RestTemplate restTemplate;

    @Value("${twitter.bearerToken}")
    String bearerToken;

    public void fetchTweetsFromTwitterApi(String query) {
        restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", bearerToken);
        httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);
        ResponseEntity<Object> object = restTemplate.exchange("https://api.twitter.com/1.1/search/tweets.json?q=%40elonmusk&count=25", HttpMethod.GET, entity, Object.class);
        System.out.println(object.getStatusCode());
        System.out.println(object.getBody().toString());


    }

}
