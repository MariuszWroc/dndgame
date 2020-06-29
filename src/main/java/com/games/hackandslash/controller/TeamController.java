package com.games.hackandslash.controller;

import com.games.hackandslash.common.MyUserMock;
import com.games.hackandslash.model.Team;
import com.games.hackandslash.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamRepository repository;

    @GetMapping("/my")
    public Team findTeamByLogin() {
        return repository.findByOwnerLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
    }
}
