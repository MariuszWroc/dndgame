package com.games.hackandslash.repository;

import com.games.hackandslash.model.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GameRepositoryTest {
    private static String login;
    @Autowired
    private GameRepository gameRepository;
    
    @BeforeAll
    public static void setUp() {
        login = "mczarny";
    }

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(gameRepository, is(notNullValue()));
    }

    @Test
    public void findByOwnerLogin() {
        Game ownerLogin = gameRepository.findByOwnerLogin(login);
    }

    @Test
    public void findByFellowLogin() {
        Game fellowLogin = gameRepository.findByFellowLogin(login);
    }

    @Test
    public void findDistinctGames() {
        Set<String> distinctGames = gameRepository.findDistinctGames();
    }
}
