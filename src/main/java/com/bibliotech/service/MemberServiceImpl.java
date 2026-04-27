package com.bibliotech.service;

import com.bibliotech.exception.ValidationException;
import com.bibliotech.model.Member;
import com.bibliotech.model.UserSearchCriteria;
import com.bibliotech.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    public MemberServiceImpl(MemberRepository memberRepository, MemberValidator memberValidator) {
        this.memberRepository = memberRepository;
        this.memberValidator = memberValidator;
    }

    @Override
    public void registerMember(Member member) throws ValidationException {
        memberValidator.validate(member, memberRepository);
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findByDni(String dni) {
        return memberRepository.findById(dni);
    }

    @Override
    public List<Member> search(UserSearchCriteria criteria) {
        return memberRepository.search(criteria);
    }
}
