package org.example.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T> implements CrudRepository<T>{
    private final Map<Integer, T> data = new HashMap<>();
    private int idCount = 1;
    @Override
    public void save(T entity) {
        data.put(idCount, entity);
        idCount++;
    }

    @Override
    public T findById(int id) {
        return data.get(id);
    }

    @Override
    public void update(int id, T entity) {
        data.put(id, entity);
    }

    @Override
    public void delete(int id) {
        data.remove(id);
    }

    @Override
    public List<T> findAll() {
        return data.values().stream().toList();
    }
}
