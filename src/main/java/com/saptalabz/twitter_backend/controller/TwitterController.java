package com.saptalabz.twitter_backend.controller;

import com.saptalabz.twitter_backend.dto.InputDto;
import com.saptalabz.twitter_backend.dto.Response;
import com.saptalabz.twitter_backend.exception.TwitterBackendException;
import com.saptalabz.twitter_backend.model.Tweet;
import com.saptalabz.twitter_backend.service.TwitterServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TwitterController {

    @Autowired
    TwitterServiceImplementation twitterServiceImplementation;


    @PostMapping("/username")
    public Response getAllTweetsByUserName(@RequestBody InputDto inputDto) throws TwitterBackendException {
        return new Response("Getting Tweets By Username.",twitterServiceImplementation.getTweetsByUsername(inputDto));
    }

    @PostMapping("/tag")
    public List<Tweet> getAllTweetsByTag(@RequestBody InputDto inputDto) throws TwitterBackendException {
        return twitterServiceImplementation.getTweetsByTag(inputDto);

    }

    @PostMapping("/both")
    public List<Tweet> getAllTweetsByBoth(@RequestBody InputDto inputDto) throws TwitterBackendException {
        return twitterServiceImplementation.getTweetsByBoth(  inputDto);
    }


}
