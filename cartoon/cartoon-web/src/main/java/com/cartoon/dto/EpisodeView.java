package com.cartoon.dto;


import com.cartoon.models.Character;
import com.cartoon.models.Episode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EpisodeView {

    private String name;
    private String air_date;
    private List<Integer> charactersSourceIds;

    public EpisodeView(Episode episode) {
        this.name = episode.getName();
        this.air_date = episode.getAir_date();
        this.charactersSourceIds = episode.getCharacters()
                .stream()
                .map(Character::getSourceId)
                .toList();
    }
}
