package com.games.hackandslash.controller;

import com.games.hackandslash.common.MyUserMock;
import com.games.hackandslash.mapper.TeamMapper;
import com.games.hackandslash.model.Team;
import com.games.hackandslash.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamRepository repository;

    @Autowired
    TeamMapper mapper;


    @GetMapping("/my")
    public Team findTeamByLogin() {
        Team team = repository.findByOwnerLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
        return team;
    }
}
