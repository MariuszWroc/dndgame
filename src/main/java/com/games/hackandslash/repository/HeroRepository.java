package com.games.hackandslash.repository;

import com.games.hackandslash.model.Profession;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.games.hackandslash.model.Hero;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HeroRepository extends PagingAndSortingRepository<Hero, Long>, QuerydslPredicateExecutor<Hero> {

}
