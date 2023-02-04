package com.cartoon.controllers;


import com.cartoon.dto.EpisodeView;
import com.cartoon.exceptions.EntityNotFoundException;
import com.cartoon.models.Character;
import com.cartoon.models.Episode;
import com.cartoon.models.Location;
import com.cartoon.services.EpisodeService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episode")
@RequiredArgsConstructor
public class EpisodeController {

    private final EpisodeService service;

    @GetMapping("/all")
    public List<EpisodeView> getEpisodes() {
        return service.getEpisodes();
    }

    @GetMapping("/search")
    public List<EpisodeView> getEpisodesByName(@RequestParam String name, @RequestParam(required = false) Integer page) {
        List<EpisodeView> episodes = service.getEpisodesByName(name);

        if (episodes.isEmpty()) {
            throw new EntityNotFoundException("There is no such episode");
        }

        if (page == null || page < 1) page = 1;
        List<EpisodeView> pagedResult = episodes.stream()
                .skip((page - 1) * 20L)
                .limit(20)
                .toList();

        return pagedResult;
    }
}
