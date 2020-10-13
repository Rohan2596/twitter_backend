package com.saptalabz.twitter_backend.configuration;

import com.saptalabz.twitter_backend.dto.twitter.TwitterDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TwitterApiConfiguration {

    RestTemplate restTemplate;

    @Value("${twitter.bearerToken}")
    String bearerToken;

    public TwitterDto fetchTweetsFromTwitterApi(String query) {
        restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", bearerToken);
        httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);
        ResponseEntity<TwitterDto> twitterDtoResponseEntity = restTemplate.exchange("https://api.twitter.com/1.1/search/tweets.json?q=%40pmmodi&count=25", HttpMethod.GET, entity, TwitterDto.class);
        System.out.println(twitterDtoResponseEntity.getStatusCode());
        System.out.println("tw:-"+twitterDtoResponseEntity.getBody().statuses);


        return new TwitterDto(twitterDtoResponseEntity.getBody());
    }

}
