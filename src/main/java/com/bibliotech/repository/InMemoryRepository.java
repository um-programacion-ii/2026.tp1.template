package com.bibliotech.repository;

import java.util.*;

public class InMemoryRepository<T, ID> implements Repository<T, ID> {

    private final Map<ID, T> storage = new HashMap<>();

    @Override
    public void guardar(T entidad) {
        // Este método necesita saber cómo obtener el ID
        // Lo dejamos simple por ahora (lo mejoramos después)
        throw new UnsupportedOperationException("Debe implementarse en repositorios específicos");
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(storage.values());
    }
}