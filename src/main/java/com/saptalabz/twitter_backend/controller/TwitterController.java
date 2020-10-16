package com.saptalabz.twitter_backend.controller;

import com.saptalabz.twitter_backend.dto.*;
import com.saptalabz.twitter_backend.exception.TwitterBackendException;
import com.saptalabz.twitter_backend.service.TwitterServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* @author  Rohan Kadam
* @purpose Twitter Controller  for getting @username,#tag and both
* */
@RestController
@RequestMapping("/tweets")
public class TwitterController {

    @Autowired
    TwitterServiceImplementation twitterServiceImplementation;


    @PostMapping("/username")
    public Response getAllTweetsByUserName(@RequestBody InputDto inputDto) throws TwitterBackendException {
        return new Response("Getting Tweets By Usernames.",twitterServiceImplementation.getTweetsByUsername(inputDto));
    }

    @PostMapping("/tag")
    public Response getAllTweetsByTag(@RequestBody InputDto inputDto) throws TwitterBackendException {
        return new Response("Getting Tweets By Tags.", twitterServiceImplementation.getTweetsByTag(inputDto));

    }

    @PostMapping("/both")
    public Response getAllTweetsByBoth(@RequestBody InputDto inputDto) throws TwitterBackendException {
        return new Response("Getting Tweets By Both.",twitterServiceImplementation.getTweetsByBoth(inputDto));
    }


}
