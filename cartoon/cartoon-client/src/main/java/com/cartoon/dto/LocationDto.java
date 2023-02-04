package com.cartoon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocationDto {
    private int id;
    private String name;
    private String type;
    private String dimension;
    @JsonProperty("residents")
    private List<String> residentsURL;
}
