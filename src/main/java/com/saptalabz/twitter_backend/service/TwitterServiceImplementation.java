package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.InputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterServiceImplementation implements ITwitterService {


    @Autowired
    TwitterApiConfiguration twitterApiConfiguration;



    @Override
    public List<String> getTweetsByUsername(InputDto inputDto) {
        createTwitterConFiguration();
        return inputDto.inputList;
    }

    @Override
    public List<String> getTweetsByTag(InputDto inputDto) {
        createTwitterConFiguration();
        return inputDto.inputList;
    }

    @Override
    public List<String> getTweetsByBoth(InputDto inputDto) {
        createTwitterConFiguration();
        return inputDto.inputList;
    }


    public void createTwitterConFiguration(){
        twitterApiConfiguration.fetchTweetsFromTwitterApi("");

    }

}
