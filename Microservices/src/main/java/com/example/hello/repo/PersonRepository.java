package com.example.hello.repo;

import com.example.hello.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data repository for {@link Person} documents.
 * <p>
 * Inherits standard CRUD operations from {@link MongoRepository}.
 */
public interface PersonRepository extends MongoRepository<Person, String> {}
