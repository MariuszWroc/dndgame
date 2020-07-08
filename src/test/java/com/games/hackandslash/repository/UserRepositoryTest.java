package com.games.hackandslash.repository;

import com.games.hackandslash.common.RoleName;
import com.games.hackandslash.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    private static String login;
    private static User user;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public static void setUpBeforeClass() {
        login = "mczarny";

        user = User.builder()
                .id(null)
                .firstname("Mariusz")
                .lastname("Czarny")
                .login("mczarny")
                .activated(true)
                .email("mczarny@gmail.com")
                .password("123")
                .role(RoleName.USER)
                .build();
    }

    @BeforeEach
    public void setUp() {
        assertThat(userRepository, is(notNullValue()));
        assertThat(userRepository.save(user), is(notNullValue()));
    }

    @Test
    public void findByLogin() {
        User user = userRepository.findByLogin(login);
        assertThat(user, is(notNullValue()));
        assertEquals(login, user.getLogin());
    }
}
