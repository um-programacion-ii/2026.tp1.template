package com.bibliotech.service;

import com.bibliotech.exception.LibraryException;
import com.bibliotech.model.Loan;
import java.util.List;

public interface LoanService extends LibraryService {
    Loan registerLoan(String isbn, String memberDni) throws LibraryException;
    long returnResource(String isbn) throws LibraryException;
    List<Loan> getHistory();
}
