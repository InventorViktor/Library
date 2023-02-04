package com.cartoon.repositories;


import com.cartoon.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findCharacterByNameContainingIgnoreCase(String name);

    @Query("select character from Character character " +
            "where lower(character.name) like lower(concat('%', :name, '%')) " +
            "or lower(character.location.name) like lower(:name)")
    List<Character> findCharacterByNameOrLocationName(String name);
}
