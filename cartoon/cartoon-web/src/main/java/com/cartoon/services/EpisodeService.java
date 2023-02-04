package com.cartoon.services;

import com.cartoon.dto.EpisodeView;
import com.cartoon.models.Episode;

import com.cartoon.repositories.catalogs.RepositoryCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final RepositoryCollector repositories;

    public List<EpisodeView> getEpisodes(){

        List<Episode> episodes = repositories.getEpisodeRepository().findAll();
        return episodes.stream()
                .map(EpisodeView::new)
                .toList();
    }

    public List<EpisodeView> getEpisodesByName(String name) {
        List<Episode> episodes = repositories.getEpisodeRepository().findEpisodeByNameContainingIgnoreCase(name);
        return episodes.stream()
                .map(EpisodeView::new)
                .toList();
    }
}
