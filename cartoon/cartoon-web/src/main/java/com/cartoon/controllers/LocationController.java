package com.cartoon.controllers;

import com.cartoon.dto.LocationView;
import com.cartoon.exceptions.EntityNotFoundException;
import com.cartoon.models.Episode;
import com.cartoon.models.Location;
import com.cartoon.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final LocationService service;

    @GetMapping("/all")
    public List<LocationView> getLocations(){

        return service.getLocations();
    }

    @GetMapping("/search")
    public List<LocationView> getLocationsByName(@RequestParam String name,  @RequestParam(required = false) Integer page){

        List<LocationView> locations = service.getLocationsByName(name);

        if (locations.isEmpty()){
            throw new EntityNotFoundException("There is no such location");
        }

        if (page == null || page < 1) page = 1;
        List<LocationView> pagedResult = locations.stream()
                .skip((page - 1) * 20L)
                .limit(20)
                .toList();

        return pagedResult;
    }
}
