package com.games.hackandslash.repository;

import com.games.hackandslash.model.Profession;
import com.games.hackandslash.model.Team;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfessionRepository extends PagingAndSortingRepository<Profession, Long>, QuerydslPredicateExecutor<Profession> {
    Profession findByName(String name);
}
