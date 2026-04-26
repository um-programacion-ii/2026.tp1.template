package com.bibliotech.service;

import com.bibliotech.exception.ValidationException;
import com.bibliotech.model.Member;
import com.bibliotech.repository.MemberRepository;

public interface MemberValidator {
    void validate(Member member, MemberRepository repository) throws ValidationException;
}
