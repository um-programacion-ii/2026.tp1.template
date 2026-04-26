package com.bibliotech.model;

public record Student(
    String dni,
    String name,
    String email
) implements Member {
    @Override
    public int maxLoans() {
        return 3;
    }
}
