package com.cartoon.mappers;

import com.cartoon.dto.CharacterDto;
import com.cartoon.dto.LocationDto;
import com.cartoon.models.Character;
import com.cartoon.models.Location;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CharacterMapper implements IMap<Character, CharacterDto>{

    @Override
    public Character map(CharacterDto dto){

        Character character = new Character();
        character.setSourceId(dto.getId());
        character.setName(dto.getName());
        character.setStatus(dto.getStatus());
        character.setSpecies(dto.getSpecies());
        character.setGender(dto.getGender());
        character.setImage(dto.getImage());

        return character;
    }
}
