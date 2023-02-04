package com.cartoon.mappers;

import com.cartoon.dto.EpisodeDto;
import com.cartoon.models.Episode;
import org.springframework.stereotype.Component;

@Component
public class EpisodeMapper implements IMap<Episode, EpisodeDto>{

    @Override
    public Episode map(EpisodeDto dto){

        Episode episode = new Episode();
        episode.setSourceId(dto.getId());
        episode.setName(dto.getName());
        episode.setAir_date(dto.getAir_date());
        return episode;
    }
}
