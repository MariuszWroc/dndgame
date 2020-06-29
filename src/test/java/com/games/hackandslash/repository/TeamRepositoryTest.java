package com.games.hackandslash.repository;

import com.games.hackandslash.common.RoleName;
import com.games.hackandslash.model.Team;
import com.games.hackandslash.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TeamRepositoryTest {
    private static String login;
    private static Team team;
    private static User user;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;

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

        team = Team.builder()
                .id(null)
                .money(100)
                .user(user)
                .heroes(null)
                .build();
    }

    @BeforeEach
    public void setUp() {
        assertThat(teamRepository, is(notNullValue()));
        assertThat(userRepository.save(user), is(notNullValue()));
        assertThat(teamRepository.save(team), is(notNullValue()));
    }

    @Test
    public void testFindByOwnerLogin() {
        Team team = teamRepository.findByOwnerLogin(login);
        assertThat(team, is(notNullValue()));
        assertEquals(login, team.getUser().getLogin());
    }
}
