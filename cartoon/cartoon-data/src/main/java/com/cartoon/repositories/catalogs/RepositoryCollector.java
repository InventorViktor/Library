package com.cartoon.repositories.catalogs;

import com.cartoon.repositories.CharacterRepository;
import com.cartoon.repositories.EpisodeRepository;
import com.cartoon.repositories.LocationRepository;

public interface RepositoryCollector {

    CharacterRepository getCharacterRepository();

    EpisodeRepository getEpisodeRepository();

    LocationRepository getLocationRepository();
}
