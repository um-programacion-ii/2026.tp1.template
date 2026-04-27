package com.bibliotech.model;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public record Loan(
    UUID id,
    String isbn,
    String memberDni,
    LocalDate loanDate,
    LocalDate dueDate,
    Optional<LocalDate> returnDate
) implements Identifiable<UUID> {}
