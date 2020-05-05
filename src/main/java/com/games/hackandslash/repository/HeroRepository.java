package com.games.hackandslash.repository;

import org.springframework.data.repository.CrudRepository;

import com.games.hackandslash.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, Long> {

}
