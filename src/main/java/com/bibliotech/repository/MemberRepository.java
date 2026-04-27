package com.bibliotech.repository;

import com.bibliotech.model.Member;
import com.bibliotech.model.UserSearchCriteria;
import java.util.List;

public interface MemberRepository extends Repository<Member, String> {
    List<Member> search(UserSearchCriteria criteria);
}
