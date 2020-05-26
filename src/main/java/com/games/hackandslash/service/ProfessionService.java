package com.games.hackandslash.service;

import com.games.hackandslash.model.Profession;
import com.games.hackandslash.repository.ProfessionRepository;
import com.games.hackandslash.util.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfessionService implements ServiceLayerCrud<Profession, Long>{
    @Autowired
    ProfessionRepository repository;

    @Override
    public void add(Profession entity) {
        repository.save(entity);
    }

    @Override
    public void addAll(Collection<Profession> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(Profession entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Profession entity) {
        delete(entity);
        add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Profession findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Profession> findAll() {
        Iterable<Profession> entities = repository.findAll();
        return StreamHelper.getStreamFromIterable(entities)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Profession findByName(String name) {
        return repository.findByName(name);
    }
}
