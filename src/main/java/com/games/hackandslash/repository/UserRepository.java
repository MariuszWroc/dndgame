package com.games.hackandslash.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.games.hackandslash.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
