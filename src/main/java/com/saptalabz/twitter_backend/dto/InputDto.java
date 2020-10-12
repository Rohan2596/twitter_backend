package com.saptalabz.twitter_backend.dto;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.util.List;

@NoArgsConstructor
public class InputDto {


    public List<String> inputList;

    public InputDto(List<String> inputList) {
        this.inputList = inputList;
    }
}
