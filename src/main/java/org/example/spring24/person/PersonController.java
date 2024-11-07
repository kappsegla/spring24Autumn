package org.example.spring24.person;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.example.spring24.person.dto.LanguagesDto;
import org.example.spring24.person.dto.PersonDto;
import org.example.spring24.person.dto.PersonWithSocialMedia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class PersonController {

    //private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonWithSocialMedia> getAllPersons() {
        return personService.allPersonsWithSocialMedia();
    }

    @PostMapping("/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonDto personDto) {
        int id = personService.addPerson(personDto);
        return ResponseEntity.created(URI.create("/persons/" + id)).build();
    }

    @PostMapping("/persons/{id}/languages")
    public void addLanguages(@PathVariable int id,
                             @RequestBody LanguagesDto languagesDto) {
        log.info("Add languages for id {}, {}", id, languagesDto.languages());
        personService.addLanguages(id, languagesDto.languages());
    }

}
