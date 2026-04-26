package com.bibliotech.model;

public record EBook(
    String isbn,
    String title,
    String author,
    int year,
    Category category,
    String fileFormat,
    double fileSizeInMB
) implements Resource {}
