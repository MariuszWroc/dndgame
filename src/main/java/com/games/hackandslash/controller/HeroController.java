package com.games.hackandslash.controller;

import com.games.hackandslash.model.Hero;
import com.games.hackandslash.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/heroes")
public class HeroController {

    @Autowired
    HeroRepository heroRepository;

    @GetMapping("/my")
    public Hero findHeroByLogin() {
        return null;
    }
}
