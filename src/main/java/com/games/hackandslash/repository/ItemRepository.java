package com.games.hackandslash.repository;

import com.games.hackandslash.model.Item;
import com.games.hackandslash.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
    Item findByName(String name);
}
