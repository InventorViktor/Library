package com.cartoon.dto.pageResoults;

import com.cartoon.dto.InfoDto;
import com.cartoon.dto.LocationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocationPageDto implements PagedResult<InfoDto, LocationDto>{

    private InfoDto info;
    private List<LocationDto> results;
}
