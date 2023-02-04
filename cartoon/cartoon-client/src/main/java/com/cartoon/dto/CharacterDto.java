package com.cartoon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CharacterDto {

    private int id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private ShortLocationDto origin;
    private ShortLocationDto location;
    private String image;
    @JsonProperty("episode")
    private List<String> episodeURL;
}
