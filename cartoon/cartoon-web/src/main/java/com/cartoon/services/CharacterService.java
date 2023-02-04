package com.cartoon.services;

import com.cartoon.dto.CharacterView;
import com.cartoon.models.Character;
import com.cartoon.repositories.catalogs.RepositoryCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final RepositoryCollector repositories;

    public List<CharacterView> getCharacters() {

        List<Character> characters = repositories.getCharacterRepository().findAll();
        return characters.stream()
                    .map(CharacterView::new)
                    .toList();
    }

    public List<CharacterView> getCharactersByNameOrLocationName(String name) {
        List<Character> characters = repositories.getCharacterRepository().findCharacterByNameOrLocationName(name);

        return characters.stream()
                .map(CharacterView::new)
                .toList();
    }
}
