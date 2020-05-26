package com.games.hackandslash.service;

import com.games.hackandslash.model.Hero;
import com.games.hackandslash.repository.HeroRepository;
import com.games.hackandslash.util.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HeroService implements ServiceLayerCrud<Hero, Long>{
    @Autowired
    HeroRepository repository;

    @Override
    public void add(Hero entity) {
        repository.save(entity);
    }

    @Override
    public void addAll(Collection<Hero> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(Hero entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Hero entity) {
        delete(entity);
        add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Hero findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Hero> findAll() {
        Iterable<Hero> entities = repository.findAll();
        return StreamHelper.getStreamFromIterable(entities)
                .collect(Collectors.toList());
    }
}
