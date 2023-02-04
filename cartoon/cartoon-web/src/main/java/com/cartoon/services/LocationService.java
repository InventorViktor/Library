package com.cartoon.services;

import com.cartoon.dto.LocationView;
import com.cartoon.models.Location;
import com.cartoon.repositories.catalogs.RepositoryCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final RepositoryCollector repositories;

    public List<LocationView> getLocations(){

        List<Location> locations = repositories.getLocationRepository().findAll();
        return locations.stream()
                .map(LocationView::new)
                .toList();
    }

    public List<LocationView> getLocationsByName(String name) {
        List<Location> locations = repositories.getLocationRepository().findLocationsByNameContainingIgnoreCase(name);
        return locations.stream()
                .map(LocationView::new)
                .toList();
    }
}
