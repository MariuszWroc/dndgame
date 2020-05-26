package com.games.hackandslash.service;

import com.games.hackandslash.model.Game;
import com.games.hackandslash.repository.GameRepository;
import com.games.hackandslash.util.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GameService implements ServiceLayerCrud<Game, Long>{
    @Autowired
    GameRepository repository;

    @Override
    public void add(Game entity) {
        repository.save(entity);
    }

    @Override
    public void addAll(Collection<Game> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(Game entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Game entity) {
        delete(entity);
        add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Game findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Game> findAll() {
        Iterable<Game> entities = repository.findAll();
        return StreamHelper.getStreamFromIterable(entities)
                .collect(Collectors.toList());
    }
}
