package com.bibliotech.model;

public interface Member extends Identifiable<String> {
    String dni();
    String name();
    String email();
    int maxLoans();

    @Override
    default String id() {
        return dni();
    }
}
