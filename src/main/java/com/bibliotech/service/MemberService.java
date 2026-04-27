package com.bibliotech.service;

import com.bibliotech.exception.ValidationException;
import com.bibliotech.model.Member;
import com.bibliotech.model.UserSearchCriteria;
import java.util.List;
import java.util.Optional;

public interface MemberService extends LibraryService {
    void registerMember(Member member) throws ValidationException;
    Optional<Member> findByDni(String dni);
    List<Member> search(UserSearchCriteria criteria);
}
