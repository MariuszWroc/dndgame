package com.games.hackandslash.repository;

import com.games.hackandslash.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>{
    Team findByUserLogin(String login);
}
