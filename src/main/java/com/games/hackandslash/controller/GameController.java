package com.games.hackandslash.controller;

import com.games.hackandslash.common.MyUserMock;
import com.games.hackandslash.dto.GameCreator;
import com.games.hackandslash.dto.GameSession;
import com.games.hackandslash.mapper.DtoMapper;
import com.games.hackandslash.model.Game;
import com.games.hackandslash.repository.GameRepository;
import com.games.hackandslash.util.StreamHelper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameRepository repository;

    @Autowired
    @Qualifier("gameCreatorMapper")
    DtoMapper<Game, GameCreator> gameCreatorMapper;

    @Autowired
    @Qualifier("gameSessionMapper")
    DtoMapper<Game, GameSession> gameSessionMapper;

    @GetMapping("/my")
    public Game findGameByLogin() {
        Game game = repository.findByOwnerLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
        System.out.println(game);
        return game;
    }

    @GetMapping("/available")
    public Iterable<GameSession> getAvailableGames(@QuerydslPredicate(root = Game.class) Predicate predicate) {
        Iterable<Game> games = repository.findAll();
        Stream<GameSession> iterator = StreamHelper.getStreamFromIterable(games)
                .map(gameSessionMapper::entityToDto).distinct();
        return StreamHelper.getIterableFromStream(iterator);
    }

    @GetMapping("/sorted")
    public Page<GameSession> getGamesSortedByName() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));
        Page<Game> games = repository.findAll(pageable);
        return games.map(gameSessionMapper::entityToDto);
    }

    @PostMapping("/create")
    public GameCreator postNewGame() {
        return null;
    }

    @PostMapping("/join")
    public GameSession joinGame(String login) {
        return null;
    }
}
