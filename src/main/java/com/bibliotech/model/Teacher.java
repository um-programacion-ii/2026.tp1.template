package com.bibliotech.model;

public record Teacher(
    String dni,
    String name,
    String email
) implements Member {
    @Override
    public int maxLoans() {
        return 5;
    }
}
