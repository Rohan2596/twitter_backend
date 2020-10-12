package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.dto.InputDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TwitterServiceTest {


    @Mock
    TwitterServiceImplementation twitterServiceImplementation;

    private InputDto inputDto;

    String username = "@RohanKadam2596";
    String tag="#developer";
    List<String> getTweets;


    @Test
    public void givenValidInput_whenInputUserName_shouldReturnValidResponse(){

        this.getTweets = new ArrayList<>();
        this.getTweets.add(username);
        this.getTweets.add(username);
        this.inputDto = new InputDto(this.getTweets);

        Mockito.when(twitterServiceImplementation.getTweetsByUsername(this.inputDto)).thenReturn(this.inputDto.inputList);
        Assertions.assertEquals(this.inputDto.inputList,twitterServiceImplementation.getTweetsByUsername(this.inputDto));

    }


    @Test
    public void givenValidInput_whenInputTag_shouldReturnValidResponse(){

        this.getTweets = new ArrayList<>();
        this.getTweets.add(tag);
        this.getTweets.add(tag);
        this.inputDto = new InputDto(this.getTweets);

        Mockito.when(twitterServiceImplementation.getTweetsByTag(this.inputDto)).thenReturn(this.inputDto.inputList);
        Assertions.assertEquals(this.inputDto.inputList,twitterServiceImplementation.getTweetsByTag(this.inputDto));

    }

    @Test
    public void givenValidInput_whenInputBoth_shouldReturnValidResponse(){

        this.getTweets = new ArrayList<>();
        this.getTweets.add(username);
        this.getTweets.add(tag);
        this.inputDto = new InputDto(this.getTweets);

        Mockito.when(twitterServiceImplementation.getTweetsByBoth(this.inputDto)).thenReturn(this.inputDto.inputList);
        Assertions.assertEquals(this.inputDto.inputList,twitterServiceImplementation.getTweetsByBoth(this.inputDto));

    }

}
