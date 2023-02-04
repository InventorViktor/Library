package com.cartoon.dto.pageResoults;

import com.cartoon.dto.EpisodeDto;
import com.cartoon.dto.InfoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EpisodesPageDto implements PagedResult<InfoDto, EpisodeDto>{

    private InfoDto info;
    private List<EpisodeDto> results;
}
