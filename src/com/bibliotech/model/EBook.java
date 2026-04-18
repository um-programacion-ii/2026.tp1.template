package com.bibliotech.model;

public record EBook(
        String isbn,
        String titulo,
        String autor,
        int anio,
        String categoria,
        double tamanioMb,
        String formatoArc
) implements Recurso {}