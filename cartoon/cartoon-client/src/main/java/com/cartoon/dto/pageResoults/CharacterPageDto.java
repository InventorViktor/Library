package com.cartoon.dto.pageResoults;

import com.cartoon.dto.CharacterDto;
import com.cartoon.dto.InfoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterPageDto implements PagedResult<InfoDto, CharacterDto>{

    private InfoDto info;
    private List<CharacterDto> results;
}
