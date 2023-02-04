package com.cartoon.repositories;

import com.cartoon.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    List<Episode> findEpisodeByNameContainingIgnoreCase(String name);
}
