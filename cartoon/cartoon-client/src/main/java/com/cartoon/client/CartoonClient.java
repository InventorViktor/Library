package com.cartoon.client;

import com.cartoon.dto.CharacterDto;
import com.cartoon.dto.LocationDto;
import com.cartoon.dto.pageResoults.CharacterPageDto;
import com.cartoon.dto.pageResoults.EpisodesPageDto;
import com.cartoon.dto.pageResoults.LocationPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CartoonClient {

    private final RestTemplate restTemplate;
    private final static String CONTAINER_API_URL = "https://rickandmortyapi.com/api";

    public CharacterPageDto getPageCharacters(int page){

        String url = CONTAINER_API_URL + "/character" + "?page=" + page;
        return restTemplate.getForObject(url, CharacterPageDto.class);
    }

    public LocationPageDto getPageLocations(int page){
        String url = CONTAINER_API_URL + "/location" + "?page=" + page;
        return restTemplate.getForObject(url, LocationPageDto.class);
    }

    public EpisodesPageDto getPageEpisodes(int page){
        String url = CONTAINER_API_URL + "/episode" + "?page=" + page;
        return restTemplate.getForObject(url, EpisodesPageDto.class);
    }

}
