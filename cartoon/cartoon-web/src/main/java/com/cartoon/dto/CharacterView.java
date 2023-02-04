package com.cartoon.dto;

import com.cartoon.models.Character;
import com.cartoon.models.Episode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterView {

    private String name;
    private String status;
    private String species;
    private String gender;
    private String originName;
    private String locationName;
    private String image;
    private List<String> episodeName;

    public CharacterView(Character character) {
        this.name = character.getName();
        this.status = character.getStatus();
        this.species = character.getSpecies();
        this.gender = character.getGender();
        this.originName = character.getOrigin().getName();
        this.locationName = character.getLocation().getName();
        this.image = character.getImage();
        this.episodeName = character.getEpisodes()
                .stream()
                .map(Episode::getName)
                .toList();
    }
}
