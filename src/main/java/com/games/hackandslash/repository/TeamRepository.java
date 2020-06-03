package com.games.hackandslash.repository;

import com.games.hackandslash.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends CrudRepository<Team, Long>{
    @Query(value = "SELECT * FROM team t JOIN user u ON t.user_id = u.id WHERE u.login = :login_param",
            nativeQuery = true)
    Team findByOwnerLogin(@Param("login_param") String login);
}
