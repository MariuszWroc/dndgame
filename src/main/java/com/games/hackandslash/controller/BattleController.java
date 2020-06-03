package com.games.hackandslash.controller;

import com.games.hackandslash.dto.Battle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/battle")
public class BattleController {

    @GetMapping("/my")
    public Battle findBattleByLogin() {
        return Battle.builder().build();
    }
}
