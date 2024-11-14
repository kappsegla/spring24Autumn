package org.example.spring24.person;

import lombok.extern.slf4j.Slf4j;
import org.example.spring24.apiauth.ApiKeyAuthService;
import org.example.spring24.entity.ApiKey;
import org.example.spring24.person.dto.LanguagesDto;
import org.example.spring24.person.dto.PersonDto;
import org.example.spring24.person.dto.PersonWithSocialMedia;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
public class PersonController {

    private final ApiKeyAuthService apiKeyAuthService;
    //private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    PersonService personService;

    public PersonController(PersonService personService, ApiKeyAuthService apiKeyAuthService) {
        this.personService = personService;
        this.apiKeyAuthService = apiKeyAuthService;
    }

    @GetMapping("/persons")
    public List<PersonWithSocialMedia> getAllPersons() {
        return  personService.allPersonsWithSocialMedia();
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

    @GetMapping("/api/test")
    @PreAuthorize("hasAuthority('read:test')")
    public Collection<ApiKey> test() {
        return apiKeyAuthService.getMyApiKeys();
    }
}


//RBAC - Role based access control
//ACL - Access Control List  ( file system )
//ABAC - Attribute based access control,
// Ask if we can do something based on
// Who are we? What do we want to do?
// What's the time? Which computer are we using?
// and everything else ...
