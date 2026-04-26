package com.bibliotech.service;

import com.bibliotech.exception.ValidationException;
import com.bibliotech.model.Resource;
import java.util.Optional;

public interface ResourceService extends LibraryService {
    void registerResource(Resource resource) throws ValidationException;
    Optional<Resource> findByIsbn(String isbn);
}
