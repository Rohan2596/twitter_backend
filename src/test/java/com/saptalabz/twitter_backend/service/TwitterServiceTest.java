package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.InputDto;
import com.saptalabz.twitter_backend.dto.twitter.SearchMetaData;
import com.saptalabz.twitter_backend.dto.twitter.StatusesDto;
import com.saptalabz.twitter_backend.dto.twitter.TwitterDto;
import com.saptalabz.twitter_backend.dto.twitter.UserDto;
import com.saptalabz.twitter_backend.model.Tweet;
import com.saptalabz.twitter_backend.repository.TweetsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
public class TwitterServiceTest {


    @InjectMocks
    TwitterServiceImplementation twitterServiceImplementation;

    @Mock
    TweetsRepository tweetsRepository;

    @Mock
    TwitterApiConfiguration twitterApiConfiguration;

    private InputDto inputDto;

    String username = "@elonmusk";
    String tag = "#developer";
    List<String> getTweets;


    TwitterDto twitterDto;
    StatusesDto statusesDto;
    UserDto userDto;
    SearchMetaData searchMetaData;
    Tweet tweet;
    List<StatusesDto> statuses = new ArrayList<StatusesDto>();

    @BeforeEach
    void setUp() {
        this.searchMetaData = new SearchMetaData(0.02,
                13153040,
                "1315904975977943040",
                "?max_id=1315904975977943039&q=%40elonmusk&count=1&include_entities=1",
                "%40elonmusk",
                "?since_id=1315904975977943040&q=%40elonmusk&include_entities=1",
                25,
                0,
                "0");
        this.userDto = new UserDto(527586907,
                "527586907",
                "Reveen Maqdasy",
                "rfmaqd",
                "Erbil, Iraq",
                "http://pbs.twimg.com/profile_images/1147983824145604610/YJ4G-Aal_normal.jpg",
                "\"https://pbs.twimg.com/profile_images/1295975423654977537/dHw9JcrK_normal.jpg");
        this.statusesDto = new StatusesDto("Tue Oct 13 06:18:01 +0000 2020",
                13158995,
                "1315899573773238272",
                "RT @elonmusk: \uD83E\uDD18 The Illuminaughty \uD83E\uDD18",
                false,
                this.userDto);
        this.statuses.add(this.statusesDto);
        this.statuses.add(this.statusesDto);
        this.twitterDto = new TwitterDto(this.statuses,
                this.searchMetaData);
        this.tweet = new Tweet(this.statusesDto);
    }

    @Test
    public void givenValidInput_whenInputUserName_shouldReturnValidResponse() {

        this.getTweets = new ArrayList<>();
        this.getTweets.add(username);
        this.getTweets.add(username);
        this.inputDto = new InputDto(this.getTweets);
        Mockito.when(this.twitterApiConfiguration.fetchTweetsFromTwitterApi(any())).thenReturn(this.twitterDto);
        Mockito.when(this.tweetsRepository.save(any())).thenReturn(this.tweet);
        Assertions.assertEquals(this.inputDto.inputList,twitterServiceImplementation.getTweetsByUsername(this.inputDto));
    }


    @Test
    public void givenValidInput_whenInputTag_shouldReturnValidResponse(){

        this.getTweets = new ArrayList<>();
        this.getTweets.add(tag);
        this.getTweets.add(tag);
        this.inputDto = new InputDto(this.getTweets);

        Mockito.when(twitterApiConfiguration.fetchTweetsFromTwitterApi(any())).thenReturn(this.twitterDto);
        Mockito.when(this.tweetsRepository.save(any())).thenReturn(this.tweet);
        Assertions.assertEquals(this.inputDto.inputList,twitterServiceImplementation.getTweetsByTag(this.inputDto));

    }

    @Test
    public void givenValidInput_whenInputBoth_shouldReturnValidResponse(){

        this.getTweets = new ArrayList<>();
        this.getTweets.add(username);
        this.getTweets.add(tag);
        this.inputDto = new InputDto(this.getTweets);

        Mockito.when(twitterApiConfiguration.fetchTweetsFromTwitterApi(any())).thenReturn(this.twitterDto);
        Mockito.when(this.tweetsRepository.save(any())).thenReturn(this.tweet);
        Assertions.assertEquals(this.inputDto.inputList,twitterServiceImplementation.getTweetsByBoth(inputDto));

    }


}
