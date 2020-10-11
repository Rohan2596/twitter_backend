package com.saptalabz.twitter_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TwitterController {

    @GetMapping("/username")
    public String getAllTweetsByUserName(@RequestParam(value = "username") String username) {
        System.out.println("Username:-- " + username);
        return username;
    }

    @GetMapping("/tag")
    public String getAllTweetsByTag(@RequestParam(value = "tag") String tag) {
        System.out.println("Tag:-- " + tag);
        return tag;
    }
    @GetMapping("/both")
    public String getAllTweetsByBoth(@RequestParam(value = "both") String both) {
        System.out.println("both:--" + both);
        return both;
    }


}
