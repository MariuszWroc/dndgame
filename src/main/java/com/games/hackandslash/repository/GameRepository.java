package com.games.hackandslash.repository;

import static com.games.hackandslash.common.GameStatus.END;

import com.games.hackandslash.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface GameRepository extends PagingAndSortingRepository<Game, Long>, QuerydslPredicateExecutor<Game> {
    @Query(value = "SELECT * FROM game g JOIN user u ON g.user_owner_id = u.id JOIN team t ON u.id = t.user_id WHERE u.login = :login_param",
            nativeQuery = true)
    Game findByOwnerLogin(@Param("login_param") String login);

    @Query(value = "SELECT * FROM game g JOIN user u ON g.user_fellow_id = u.id WHERE u.login = :login_param",
            nativeQuery = true)
    Game findByFellowLogin(@Param("login_param") String login);

    @Query("SELECT DISTINCT g.name FROM Game g")
    Set<String> findDistinctGames();
}
