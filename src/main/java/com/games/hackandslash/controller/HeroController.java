package com.games.hackandslash.controller;

import com.games.hackandslash.dto.HeroCreator;
import com.games.hackandslash.mapper.HeroMapper;
import com.games.hackandslash.model.Hero;
import com.games.hackandslash.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/hero")
public class HeroController {

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    HeroMapper heroMapper;

    @GetMapping("/{id}")
    public HeroCreator findUserByLogin(Long id) {
        Optional<Hero> hero = heroRepository.findById(id);
        return heroMapper.entityToDto(hero.get());
    }
}
