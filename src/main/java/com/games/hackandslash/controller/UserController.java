package com.games.hackandslash.controller;

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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserController extends UserMapper {
    public static final String CURRENT_LOGIN_MOCK = "mczarny";

    @Autowired
    UserRepository userRepository;

    @GetMapping("/myuser")
    public User findUserByLogin() {
        return userRepository.findByLogin(CURRENT_LOGIN_MOCK);
    }

    @GetMapping("/users")
    public List<UserProfile> findAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/filteredusers")
    public Iterable<UserProfile> getUsersByQuerydslPredicate(@QuerydslPredicate(root = User.class) Predicate predicate) {
        Iterable<User> users = userRepository.findAll(predicate);
        StreamHelper.getStreamFromIterable(users).forEach(System.out::println);
        Stream<UserProfile> iterator = StreamHelper.getStreamFromIterable(users)
                .map(this::entityToDto);
        List<UserProfile> list = StreamHelper.getStreamFromIterable(users)
                .map(this::entityToDto).collect(Collectors.toList());
        list.forEach(System.out::println);
        return StreamHelper.getIterableFromStream(iterator);
    }

    @GetMapping("/sortedusers")
    public Page<User> findAllUsersSortedByLogin() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("login"));
        return userRepository.findAll(pageable);
    }
}
