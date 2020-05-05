package com.games.hackandslash.repository;

import org.springframework.data.repository.CrudRepository;

import com.games.hackandslash.model.Item;


public interface ItemRepository extends CrudRepository<Item, Long>{

}
