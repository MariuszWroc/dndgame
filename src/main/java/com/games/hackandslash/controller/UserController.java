package com.games.hackandslash.controller;

import com.games.hackandslash.mapper.UserMapper;
import com.games.hackandslash.model.User;
import com.games.hackandslash.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends UserMapper {
    public static final String CURRENT_LOGIN_MOCK = "mczarny";

    @Autowired
    UserRepository userRepository;

    @GetMapping("/myuser")
    public User findUserByLogin() {
        return userRepository.findByLogin(CURRENT_LOGIN_MOCK);
    }

    @GetMapping("/filteredusers")
    public Iterable<User> getUsersByQuerydslPredicate(@QuerydslPredicate(root = User.class) Predicate predicate) {
        return userRepository.findAll(predicate);
    }

    @GetMapping("/sortedusers")
    public Page<User> findAllUsersSortedByLogin() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("login"));
        return userRepository.findAll(pageable);
    }
}
