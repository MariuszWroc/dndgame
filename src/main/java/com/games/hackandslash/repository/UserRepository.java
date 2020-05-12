package com.games.hackandslash.repository;

import com.games.hackandslash.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
}
