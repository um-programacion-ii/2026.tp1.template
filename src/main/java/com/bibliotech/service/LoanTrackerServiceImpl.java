package com.bibliotech.service;

import com.bibliotech.model.Loan;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LoanTrackerServiceImpl implements LoanTrackerService {
    @Override
    public long getDaysLeft(Loan loan) {
        return ChronoUnit.DAYS.between(LocalDate.now(), loan.dueDate());
    }

    @Override
    public long getDelay(Loan loan) {
        long delay = ChronoUnit.DAYS.between(loan.dueDate(), LocalDate.now());
        return Math.max(0, delay);
    }
}
