package com.bibliotech.model;

public interface Resource extends Identifiable<String> {
    String isbn();
    String title();
    String author();
    int year();
    Category category();

    @Override
    default String id() {
        return isbn();
    }
}
