package com.bibliotech.service;

import com.bibliotech.exception.LibraryException;
import com.bibliotech.model.Loan;
import com.bibliotech.model.Member;
import com.bibliotech.repository.LoanRepository;
import java.util.List;

public interface LoanValidator {
    void validateNewLoan(String isbn, Member member, List<Loan> activeLoans, LoanRepository repository) throws LibraryException;
}
