package com.example.hello.web;

import com.example.hello.model.Person;
import com.example.hello.repo.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * REST controller exposing endpoints to manage person details.
 */
@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonRepository repo;

    /**
     * Creates a controller with the required repository dependency.
     *
     * @param repo repository for persisting and retrieving persons
     */
    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    /**
     * Creates and stores a new person document based on the provided payload.
     *
     * @param input request body containing firstName and lastName
     * @return 201 Created with the saved document in the body and a Location header;
     *         400 Bad Request if validation fails
     */
    @PostMapping("/personDetails")
    public ResponseEntity<Person> create(@RequestBody Person input) {
        if (input.getFirstName() == null || input.getFirstName().isBlank() ||
            input.getLastName() == null || input.getLastName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Person saved = repo.save(new Person(input.getFirstName(), input.getLastName()));
        return ResponseEntity.created(URI.create("/api/personDetails/" + saved.getId())).body(saved);
    }
}
