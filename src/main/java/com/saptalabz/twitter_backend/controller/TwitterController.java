package com.saptalabz.twitter_backend.controller;

import com.saptalabz.twitter_backend.dto.InputDto;
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
    public List<String> getAllTweetsByUserName(@RequestBody InputDto inputDto) {
        twitterServiceImplementation.getTweetsByUsername(inputDto);
        return inputDto.inputList;
    }

    @PostMapping("/tag")
    public List<String> getAllTweetsByTag(@RequestBody InputDto inputDto) {
        twitterServiceImplementation.getTweetsByUsername(inputDto);

        return inputDto.inputList;
    }

    @PostMapping("/both")
    public List<String> getAllTweetsByBoth(@RequestBody InputDto inputDto) {
        twitterServiceImplementation.getTweetsByUsername(inputDto);

        return inputDto.inputList;
    }


}
