package com.cartoon.mappers.collector;

import com.cartoon.dto.CharacterDto;
import com.cartoon.dto.EpisodeDto;
import com.cartoon.dto.LocationDto;
import com.cartoon.mappers.IMap;
import com.cartoon.mappers.collector.ICollectMappers;
import com.cartoon.models.Character;
import com.cartoon.models.Episode;
import com.cartoon.models.Location;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class MappersCollector implements ICollectMappers {

    private final IMap<Character, CharacterDto> characterMapper;
    private final IMap<Location, LocationDto> locationMapper;
    private final IMap<Episode, EpisodeDto> episodeMapper;

}
