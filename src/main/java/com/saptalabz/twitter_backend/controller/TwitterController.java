package com.saptalabz.twitter_backend.controller;

import com.saptalabz.twitter_backend.dto.InputDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TwitterController {


    @GetMapping("/username")
    public List<String> getAllTweetsByUserName(@RequestBody InputDto inputDto) {
        System.out.println("Username:-- " + inputDto.inputList);
        return inputDto.inputList;
    }

    @GetMapping("/tag")
    public List<String> getAllTweetsByTag(@RequestBody InputDto inputDto) {
        System.out.println("Tag:-- " + inputDto.inputList);
        return inputDto.inputList;
    }

    @GetMapping("/both")
    public List<String> getAllTweetsByBoth(@RequestBody InputDto inputDto) {
        System.out.println("both:--" + inputDto.inputList);
        return inputDto.inputList;
    }


}
