package com.games.hackandslash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @GetMapping()
    public void findGames() {
    };

    @PostMapping()
    public void create() {

    };

    @PostMapping()
    public void join() {

    }

    @PostMapping()
    public void stop() {

    }

}
