package com.cartoon.mappers.collector;

import com.cartoon.dto.CharacterDto;
import com.cartoon.dto.EpisodeDto;
import com.cartoon.dto.LocationDto;
import com.cartoon.mappers.IMap;
import com.cartoon.models.Character;
import com.cartoon.models.Episode;
import com.cartoon.models.Location;

public interface ICollectMappers {

    IMap<Character, CharacterDto> getCharacterMapper();
    IMap<Location, LocationDto> getLocationMapper();
    IMap<Episode, EpisodeDto> getEpisodeMapper();
}
