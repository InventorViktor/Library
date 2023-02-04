package com.cartoon.controllers;

import com.cartoon.dto.CharacterView;
import com.cartoon.exceptions.EntityNotFoundException;
import com.cartoon.services.CharacterService;
import com.cartoon.models.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @GetMapping("/all")
    public String getCharacters(@RequestParam(required = false) Integer page, Model model) {
        List<CharacterView> characters = service.getCharacters();

        if (page == null || page < 1) page = 1;
        List<CharacterView> pagedResult = characters.stream()
                .skip((page - 1) * 20L)
                .limit(20)
                .toList();

        model.addAttribute("characters", pagedResult);
        return "characters";
    }

    @GetMapping("/search")
    public String getCharactersByNameOrFullLocationName(@RequestParam String name, @RequestParam(required = false) Integer page, Model model) {
        List<CharacterView> characters = service.getCharactersByNameOrLocationName(name);
        if (characters.isEmpty()) {
            return "emptyResult";
        }

        if (page == null || page < 1) page = 1;
        List<CharacterView> pagedResult = characters.stream()
                .skip((page - 1) * 20L)
                .limit(20)
                .toList();

        model.addAttribute("characters", pagedResult);
        return "characters";
    }
}
