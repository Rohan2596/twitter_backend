package com.saptalabz.twitter_backend.controller;

import com.google.gson.Gson;
import com.saptalabz.twitter_backend.dto.InputDto;
import com.saptalabz.twitter_backend.dto.Response;
import com.saptalabz.twitter_backend.dto.twitter.SearchMetaData;
import com.saptalabz.twitter_backend.dto.twitter.StatusesDto;
import com.saptalabz.twitter_backend.dto.twitter.TwitterDto;
import com.saptalabz.twitter_backend.dto.twitter.UserDto;
import com.saptalabz.twitter_backend.model.Tweet;
import com.saptalabz.twitter_backend.service.TwitterServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class TwitterControllerTest {


    @Autowired
    MockMvc mockMvc;

    private InputDto inputDto;

    String username = "@RohanKadam2596";
    List<Tweet> getTweets;
    List<String> searchInput = new ArrayList<>();


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


    @MockBean
    TwitterServiceImplementation twitterServiceImplementation;

    @Test
    public void givenValidSearchInput_whenSearchByUsername_shouldReturnValidResponse() throws Exception {
        this.searchInput.add(username);
        this.searchInput.add(username);
        this.getTweets = new ArrayList<>();
        this.getTweets.add(new Tweet(this.statusesDto));
        this.getTweets.add(new Tweet(this.statusesDto));
        this.inputDto = new InputDto(this.searchInput);
        Mockito.when(twitterServiceImplementation.getTweetsByUsername(any())).thenReturn(this.getTweets);
        MvcResult mvcResult = this.mockMvc.perform(post("/tweets/username")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();

        Assertions.assertEquals(200,
                mvcResult.getResponse().getStatus());

    }

    @Test
    public void givenInValidSearchInput_whenSearchByUsername_shouldReturnValidResponse() throws Exception {

        this.getTweets = new ArrayList<>();
        this.getTweets.add(new Tweet(this.statusesDto));
        this.getTweets.add(new Tweet(this.statusesDto));
        this.inputDto = new InputDto(this.searchInput);
        Mockito.when(twitterServiceImplementation.getTweetsByUsername(any())).thenReturn(this.getTweets);
        MvcResult mvcResult = this.mockMvc.perform(post("/tweets/username")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();

        Assertions.assertEquals("Getting Tweets By Usernames.",
                new Gson().fromJson(mvcResult.getResponse().getContentAsString(), Response.class).message);


    }

    @Test
    public void givenValidSearchInput_whenSearchByTag_shouldReturnValidResponse() throws Exception {
        String tag = "#developer";
        this.searchInput.add(tag);
        this.searchInput.add(tag);
        this.getTweets = new ArrayList<>();
        this.getTweets.add(new Tweet(this.statusesDto));
        this.getTweets.add(new Tweet(this.statusesDto));
        this.inputDto = new InputDto(this.searchInput);
        Mockito.when(twitterServiceImplementation.getTweetsByTag(any())).thenReturn(this.getTweets);

        MvcResult mvcResult = this.mockMvc.perform(post("/tweets/tag")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }
    @Test
    public void givenInValidSearchInput_whenSearchByTag_shouldReturnValidResponse() throws Exception {

        this.getTweets = new ArrayList<>();
        this.getTweets.add(new Tweet(this.statusesDto));
        this.getTweets.add(new Tweet(this.statusesDto));
        this.inputDto = new InputDto(this.searchInput);
        Mockito.when(twitterServiceImplementation.getTweetsByUsername(any())).thenReturn(this.getTweets);
        MvcResult mvcResult = this.mockMvc.perform(post("/tweets/tag")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();

        Assertions.assertEquals("Getting Tweets By Tags.",
                new Gson().fromJson(mvcResult.getResponse().getContentAsString(), Response.class).message);


    }


    @Test
    public void givenValidSearchInput_whenSearchByBoth_shouldReturnValidResponse() throws Exception {
        String tag = "#developer";
        this.searchInput.add(tag);
        this.searchInput.add(username);
        this.getTweets = new ArrayList<>();
        this.getTweets.add(new Tweet(this.statusesDto));
        this.getTweets.add(new Tweet(this.statusesDto));
        this.inputDto = new InputDto(this.searchInput);
        Mockito.when(twitterServiceImplementation.getTweetsByBoth(any())).thenReturn(this.getTweets);
        MvcResult mvcResult = this.mockMvc.perform(post("/tweets/both")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    @Test
    public void givenInValidSearchInput_whenSearchByBoth_shouldReturnValidResponse() throws Exception {

        this.getTweets = new ArrayList<>();
        this.getTweets.add(new Tweet(this.statusesDto));
        this.getTweets.add(new Tweet(this.statusesDto));
        this.inputDto = new InputDto(this.searchInput);
        Mockito.when(twitterServiceImplementation.getTweetsByUsername(any())).thenReturn(this.getTweets);
        MvcResult mvcResult = this.mockMvc.perform(post("/tweets/both")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();

        Assertions.assertEquals("Getting Tweets By Both.",
                new Gson().fromJson(mvcResult.getResponse().getContentAsString(), Response.class).message);


    }


}
