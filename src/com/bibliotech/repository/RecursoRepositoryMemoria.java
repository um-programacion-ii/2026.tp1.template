package com.bibliotech.repository;

import com.bibliotech.model.Recurso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RecursoRepositoryMemoria implements Repository<Recurso, String> {
    // Usamos el ISBN como clave (String) y el Recurso como valor
    private final Map<String, Recurso> baseDeDatos = new HashMap<>();

    @Override
    public void guardar(Recurso recurso) {
        baseDeDatos.put(recurso.isbn(), recurso);
    }

    @Override
    public Optional<Recurso> buscarPorId(String isbn) {
        // Optional.ofNullable maneja elegantemente si el mapa devuelve null
        return Optional.ofNullable(baseDeDatos.get(isbn));
    }

    @Override
    public List<Recurso> buscarTodos() {
        return new ArrayList<>(baseDeDatos.values());
    }
}