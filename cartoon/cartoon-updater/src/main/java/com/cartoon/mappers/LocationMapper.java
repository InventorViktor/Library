package com.cartoon.mappers;

import com.cartoon.dto.LocationDto;
import com.cartoon.models.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements IMap<Location, LocationDto>{

   @Override
    public Location map(LocationDto dto){
       Location location = new Location();
       location.setSourceId(dto.getId());
       location.setName(dto.getName());
       location.setType(dto.getType());
       location.setDimension(dto.getDimension());
       return location;
    }
}
