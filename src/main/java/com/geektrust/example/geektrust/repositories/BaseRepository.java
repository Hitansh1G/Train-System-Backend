package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Route;

import java.util.*;

public abstract class BaseRepository<T> {
    private final Map<String, T> entityMap = new HashMap<>();
    private int autoIncrement = 0;

    public T save(T entity) {
        if (getId(entity) == null) {
            autoIncrement++;
            setId(entity, String.valueOf(autoIncrement));
        }
        entityMap.put(getId(entity), entity);
        return entity;
    }

    public List<T> findAll() {
        return (List<T>) new ArrayList<>(entityMap.values());
    }


    public Optional<T> findById(String id) {
        return Optional.ofNullable(entityMap.get(id));
    }

    public void delete(T entity) {
        entityMap.remove(getId(entity));
    }

    public void deleteById(String id) {
        entityMap.remove(id);
    }

    public long count() {
        return entityMap.size();
    }

    protected abstract String getId(T entity);

    protected abstract void setId(T entity, String id);
}
