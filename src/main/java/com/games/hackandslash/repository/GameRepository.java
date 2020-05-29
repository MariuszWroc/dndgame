package com.games.hackandslash.repository;

import com.games.hackandslash.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends PagingAndSortingRepository<Game, Long>, QuerydslPredicateExecutor<Game> {
    @Query(value = "select * from game g join user_team_mapping map on g.id = map.game_id join user u on map.user_id = u.id where u.login = :login_param",
            nativeQuery = true)
    Game findByUserLogin(@Param("login_param") String login);
}
