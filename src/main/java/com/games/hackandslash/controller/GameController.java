package com.games.hackandslash.controller;

import com.games.hackandslash.common.GameStatus;
import com.games.hackandslash.common.MyUserMock;
import com.games.hackandslash.model.Game;
import com.games.hackandslash.repository.GameRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    GameRepository repository;

    @GetMapping("/my")
    public Game findGameByLogin() {
        return repository.findByOwnerLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
    }

    @GetMapping("/sorted")
    public Page<Game> getGamesSortedByName() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));
        return repository.findAll(pageable);
    }

    @PostMapping("/create")
    public Game postNewGame() {
        return null;
    }

    @PutMapping("/wait")
    public Game waitForPlayers(String login) {
        Game game = repository.findByOwnerLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
        game.setGameStatus(GameStatus.WAITING_FOR_PLAYER);
        return game;
    }

    @PutMapping("/join")
    public Game joinGame(String login) {
        return null;
    }
}
