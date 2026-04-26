package com.bibliotech.model;

public record PhysicalBook(
    String isbn,
    String title,
    String author,
    int year,
    Category category,
    String shelfLocation
) implements Resource {}
