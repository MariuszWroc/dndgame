package com.games.hackandslash.controller;

import com.games.hackandslash.dto.UserProfile;
import com.games.hackandslash.mapper.UserMapper;
import com.games.hackandslash.model.User;
import com.games.hackandslash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    public static final String CURRENT_LOGIN_MOCK = "mczarny";

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/actualProfile")
    public UserProfile findUserByLogin() {
        User user = userRepository.findUserByLogin(CURRENT_LOGIN_MOCK);
        return userMapper.entityToDto(user);
    }

}
