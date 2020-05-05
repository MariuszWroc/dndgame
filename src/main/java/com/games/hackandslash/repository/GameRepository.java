package com.games.hackandslash.repository;

import org.springframework.data.repository.CrudRepository;

import com.games.hackandslash.model.Game;

public interface GameRepository extends CrudRepository<Game, Long>{

}
