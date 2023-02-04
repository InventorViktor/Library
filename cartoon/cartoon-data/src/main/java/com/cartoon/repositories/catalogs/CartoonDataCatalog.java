package com.cartoon.repositories.catalogs;

import com.cartoon.repositories.CharacterRepository;
import com.cartoon.repositories.EpisodeRepository;
import com.cartoon.repositories.LocationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@RequiredArgsConstructor
@Repository
public class CartoonDataCatalog implements RepositoryCollector {

    private final CharacterRepository characterRepository;
    private final EpisodeRepository episodeRepository;
    private final LocationRepository locationRepository;
}
