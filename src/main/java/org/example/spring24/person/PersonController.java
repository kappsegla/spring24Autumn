package org.example.spring24.person;

import org.example.spring24.person.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonDto> getAllPersons() {
        return personService.allPersons();
    }

    @PostMapping("/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonDto personDto) {
        int id = personService.addPerson(personDto);
        return ResponseEntity.created(URI.create("/persons/" + id)).build();
    }
}
