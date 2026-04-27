package com.bibliotech.service;

import com.bibliotech.model.Loan;

public interface LoanTrackerService {
    long getDaysLeft(Loan loan);
    long getDelay(Loan loan);
}
