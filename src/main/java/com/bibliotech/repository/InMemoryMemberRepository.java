package com.bibliotech.repository;

import com.bibliotech.model.Member;
import com.bibliotech.model.UserSearchCriteria;
import java.util.stream.Collectors;
import java.util.List;

public class InMemoryMemberRepository extends InMemoryRepository<Member, String> implements MemberRepository {
    @Override
    public List<Member> search(UserSearchCriteria criteria) {
        return findAll().stream()
            .filter(m -> criteria.dni() == null || m.dni().contains(criteria.dni()))
            .filter(m -> criteria.name() == null || m.name().toLowerCase().contains(criteria.name().toLowerCase()))
            .filter(m -> criteria.type() == null || criteria.type().isInstance(m))
            .collect(Collectors.toList());
    }
}
