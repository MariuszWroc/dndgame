package com.games.hackandslash.service;

import java.io.Serializable;
import java.util.Collection;

public interface ServiceLayerCrud<T, PK extends Serializable> {
    void add(T entity);
    void addAll(Collection<T> entities);
    void delete(T entity);
    void delete(PK id);
    void update(T entity);
    T findById(PK id);
    Collection<T> findAll();
}
