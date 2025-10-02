package com.example.hello.web;

import com.example.hello.model.Person;
import com.example.hello.repo.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

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

