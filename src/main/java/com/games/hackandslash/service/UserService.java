package com.games.hackandslash.service;

import com.games.hackandslash.model.User;
import com.games.hackandslash.repository.UserRepository;
import com.games.hackandslash.util.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements ServiceLayerCrud<User, Long>{
    @Autowired
    UserRepository repository;

    @Override
    public void add(User entity) {
        repository.save(entity);
    }

    @Override
    public void addAll(Collection<User> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(User entity) {
        delete(entity);
        add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        Iterable<User> entities = repository.findAll();
        return StreamHelper.getStreamFromIterable(entities)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }
}
