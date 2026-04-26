package com.bibliotech.model;

public record SearchCriteria(
    String title,
    String author,
    Category category,
    Class<? extends Resource> type
) {}
