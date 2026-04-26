package com.bibliotech.repository;

import com.bibliotech.model.Resource;
import com.bibliotech.model.SearchCriteria;
import java.util.List;

public interface ResourceRepository extends Repository<Resource, String> {
    List<Resource> search(SearchCriteria criteria);
}
