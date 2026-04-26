package com.bibliotech.service;

import com.bibliotech.exception.ValidationException;
import com.bibliotech.model.Resource;
import com.bibliotech.model.SearchCriteria;
import java.util.List;
import java.util.Optional;

public interface ResourceService extends LibraryService {
    void registerResource(Resource resource) throws ValidationException;
    Optional<Resource> findByIsbn(String isbn);
    List<Resource> search(SearchCriteria criteria);
}
