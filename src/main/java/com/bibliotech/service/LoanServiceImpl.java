package com.bibliotech.service;

import com.bibliotech.exception.*;
import com.bibliotech.model.*;
import com.bibliotech.repository.LoanRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoanServiceImpl implements LoanService {
    private final ResourceService resourceService;
    private final MemberService memberService;
    private final LoanRepository loanRepository;

    public LoanServiceImpl(ResourceService resourceService, MemberService memberService, LoanRepository loanRepository) {
        this.resourceService = resourceService;
        this.memberService = memberService;
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan registerLoan(String isbn, String memberDni) throws LibraryException {
        Resource resource = resourceService.findByIsbn(isbn)
            .orElseThrow(() -> new EntityNotFoundException("Resource not found: " + isbn));
        
        Member member = memberService.findByDni(memberDni)
            .orElseThrow(() -> new EntityNotFoundException("Member not found: " + memberDni));

        if (!loanRepository.findActiveByIsbn(isbn).isEmpty()) {
            throw new ResourceNotAvailableException("Resource is already loaned: " + isbn);
        }

        if (loanRepository.findActiveByMemberDni(memberDni).size() >= member.maxLoans()) {
            throw new MemberLimitExceededException("Member reached maximum loan limit: " + memberDni);
        }

        Loan loan = new Loan(
            UUID.randomUUID(),
            isbn,
            memberDni,
            LocalDate.now(),
            LocalDate.now().plusDays(7),
            Optional.empty()
        );

        loanRepository.save(loan);
        return loan;
    }

    @Override
    public List<Loan> getHistory() {
        return loanRepository.findAll();
    }
}
