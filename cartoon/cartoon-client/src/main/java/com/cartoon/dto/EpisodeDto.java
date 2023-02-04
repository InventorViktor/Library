package com.cartoon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EpisodeDto {
    private int id;
    private String name;
    private String air_date;
    @JsonProperty("characters")
    private List<String> charactersURL;
}
