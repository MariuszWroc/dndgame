package com.games.hackandslash.service;

import com.games.hackandslash.model.Item;
import com.games.hackandslash.repository.ItemRepository;
import com.games.hackandslash.util.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemService implements ServiceLayerCrud<Item, Long>{
    @Autowired
    ItemRepository repository;

    @Override
    public void add(Item entity) {
        repository.save(entity);
    }

    @Override
    public void addAll(Collection<Item> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(Item entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Item entity) {
        delete(entity);
        add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Item findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Item> findAll() {
        Iterable<Item> entities = repository.findAll();
        return StreamHelper.getStreamFromIterable(entities)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Item findByName(String name) {
        return repository.findByName(name);
    }
}
