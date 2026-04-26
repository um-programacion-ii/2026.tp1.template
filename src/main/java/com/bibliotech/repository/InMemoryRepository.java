package com.bibliotech.repository;

import com.bibliotech.model.Identifiable;
import java.util.*;

public class InMemoryRepository<T extends Identifiable<ID>, ID> implements Repository<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();

    @Override
    public void save(T entity) {
        storage.put(entity.id(), entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}
