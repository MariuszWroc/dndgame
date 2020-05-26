package com.games.hackandslash.repository;

import com.games.hackandslash.model.Profession;
import org.springframework.data.repository.CrudRepository;

public interface ProfessionRepository extends CrudRepository<Profession, Long> {
    Profession findByName(String name);
}
