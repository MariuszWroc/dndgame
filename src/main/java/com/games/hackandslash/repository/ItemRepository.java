package com.games.hackandslash.repository;

import com.games.hackandslash.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
