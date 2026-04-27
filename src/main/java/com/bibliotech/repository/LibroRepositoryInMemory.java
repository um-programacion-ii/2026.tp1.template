package com.bibliotech.repository;

import com.bibliotech.model.Libro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LibroRepositoryInMemory implements LibroRepository {

    private final Map<String, Libro> libros = new HashMap<>();

    @Override
    public void guardar(Libro libro) {
        libros.put(libro.isbn(), libro);
    }

    @Override
    public Optional<Libro> buscarPorId(String isbn) {
        return Optional.ofNullable(libros.get(isbn));
    }

    @Override
    public List<Libro> buscarTodos() {
        return new ArrayList<>(libros.values());
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return libros.values().stream()
                .filter(libro -> libro.titulo().equalsIgnoreCase(titulo))
                .toList();
    }

    @Override
    public List<Libro> buscarPorAutor(String autor) {
        return libros.values().stream()
                .filter(libro -> libro.autor().equalsIgnoreCase(autor))
                .toList();
    }

    @Override
    public List<Libro> buscarPorCategoria(String categoria) {
        return libros.values().stream()
                .filter(libro -> libro.categoria().equalsIgnoreCase(categoria))
                .toList();
    }
}