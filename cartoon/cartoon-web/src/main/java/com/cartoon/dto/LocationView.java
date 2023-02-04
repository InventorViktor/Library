package com.cartoon.dto;


import com.cartoon.models.Character;
import com.cartoon.models.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocationView {

    private String name;
    private String type;
    private String dimension;
    private List<Integer> residentsSourceIds;

    public LocationView(Location location) {
        this.name = location.getName();
        this.type = location.getType();
        this.dimension = location.getDimension();
        this.residentsSourceIds = location.getResidents()
                .stream()
                .map(Character::getSourceId)
                .toList();
    }
}
