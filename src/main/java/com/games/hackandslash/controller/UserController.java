package com.games.hackandslash.controller;

import com.games.hackandslash.common.MyUserMock;
import com.games.hackandslash.dto.UserProfile;
import com.games.hackandslash.mapper.UserMapper;
import com.games.hackandslash.model.User;
import com.games.hackandslash.repository.UserRepository;
import com.games.hackandslash.util.StreamHelper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    @GetMapping("/myuser")
    public UserProfile findUserByLogin() {
        User user = repository.findByLogin(MyUserMock.CURRENT_LOGIN_MOCK.getLogin());
        return mapper.entityToDto(user);
    }

    @GetMapping("/users")
    public Iterable<UserProfile> getAll(@QuerydslPredicate(root = User.class) Predicate predicate) {
        Iterable<User> users = repository.findAll(predicate);
        Stream<UserProfile> iterator = StreamHelper.getStreamFromIterable(users)
                .map(mapper::entityToDto);
        return StreamHelper.getIterableFromStream(iterator);
    }

    @GetMapping("/sortedusers")
    public Page<UserProfile> getUsersSortedByLogin() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("login"));
        Page<User> users = repository.findAll(pageable);
        return users.map(mapper::entityToDto);
    }
}
