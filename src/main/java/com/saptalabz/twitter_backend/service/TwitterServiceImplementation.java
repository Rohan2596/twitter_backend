package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.InputDto;
import com.saptalabz.twitter_backend.dto.twitter.StatusesDto;
import com.saptalabz.twitter_backend.dto.twitter.TwitterDto;
import com.saptalabz.twitter_backend.model.Tweet;
import com.saptalabz.twitter_backend.repository.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterServiceImplementation implements ITwitterService {


    @Autowired
    TwitterApiConfiguration twitterApiConfiguration;



    @Autowired
    TweetsRepository tweetsRepository;


    @Override
    public List<Tweet> getTweetsByUsername(InputDto inputDto) {
        saveToRepository(queryCreation(inputDto));
        return tweetsRepository.findAll();
    }

    @Override
    public List<Tweet> getTweetsByTag(InputDto inputDto) {
        saveToRepository(queryCreation(inputDto));
        return tweetsRepository.findAll();
    }

    @Override
    public List<Tweet> getTweetsByBoth(InputDto inputDto) {
        saveToRepository(queryCreation(inputDto));
        return tweetsRepository.findAll();
    }


    public TwitterDto queryCreation(InputDto inputDto) {
        String query = "";
        for (String value : inputDto.inputList) {
            if (value.contains("@")) {
                String replace = value.replace("@", "%40");
                query = replace + "+";
            }
            if (value.contains("#")) {
                String replace = value.replace("#", "%23");
                query = replace + "+";
                System.out.println(query);
            }

        }

        return twitterApiConfiguration.fetchTweetsFromTwitterApi(query);

    }

    public Tweet saveToRepository(TwitterDto twitterDto) {
        List<Tweet> tweets = new ArrayList<>();
        for (StatusesDto statusesDto : twitterDto.statuses) {
            Tweet tweet = new Tweet(statusesDto);
            tweets.add(tweet);
            tweetsRepository.save(tweet);
        }
        return tweets.get(0);
    }
}
