package com.games.hackandslash.service;

import com.games.hackandslash.model.Team;
import com.games.hackandslash.repository.TeamRepository;
import com.games.hackandslash.util.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamService implements ServiceLayerCrud<Team, Long>{
    @Autowired
    TeamRepository repository;

    @Override
    public void add(Team entity) {
        repository.save(entity);
    }

    @Override
    public void addAll(Collection<Team> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(Team entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Team entity) {
        delete(entity);
        add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Team findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Team> findAll() {
        Iterable<Team> entities = repository.findAll();
        return StreamHelper.getStreamFromIterable(entities)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Team findByUserLogin(String mczarny) {
        return repository.findByUserLogin(mczarny);
    }
}
