package com.bibliotech.repository;

import com.bibliotech.model.Loan;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryLoanRepository extends InMemoryRepository<Loan, UUID> implements LoanRepository {
    @Override
    public List<Loan> findActiveByIsbn(String isbn) {
        return findAll().stream()
            .filter(l -> l.isbn().equals(isbn) && l.returnDate().isEmpty())
            .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findActiveByMemberDni(String dni) {
        return findAll().stream()
            .filter(l -> l.memberDni().equals(dni) && l.returnDate().isEmpty())
            .collect(Collectors.toList());
    }
}
