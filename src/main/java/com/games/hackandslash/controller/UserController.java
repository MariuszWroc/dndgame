package com.games.hackandslash.controller;

import com.games.hackandslash.common.MyUserMock;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/my")
    public User findUserByLogin() {
        return repository.findByLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
    }

    @GetMapping("/sorted")
    public Page<User> getUsersSortedByLogin() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("login"));
        return repository.findAll(pageable);
    }
}
