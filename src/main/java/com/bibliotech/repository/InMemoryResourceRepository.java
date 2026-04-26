package com.bibliotech.repository;

import com.bibliotech.model.Resource;
import com.bibliotech.model.SearchCriteria;
import java.util.stream.Collectors;
import java.util.List;

public class InMemoryResourceRepository extends InMemoryRepository<Resource, String> implements ResourceRepository {
    @Override
    public List<Resource> search(SearchCriteria criteria) {
        return findAll().stream()
            .filter(r -> criteria.title() == null || r.title().toLowerCase().contains(criteria.title().toLowerCase()))
            .filter(r -> criteria.author() == null || r.author().toLowerCase().contains(criteria.author().toLowerCase()))
            .filter(r -> criteria.category() == null || r.category() == criteria.category())
            .filter(r -> criteria.type() == null || criteria.type().isInstance(r))
            .collect(Collectors.toList());
    }
}
