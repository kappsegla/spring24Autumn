package org.example.spring24.person;

import org.example.spring24.language.LanguageService;
import org.example.spring24.person.dto.PersonDto;
import org.example.spring24.person.dto.PersonWithSocialMedia;
import org.example.spring24.person.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;
    LanguageService languageService;

    public PersonService(PersonRepository personRepository, LanguageService languageService) {
        this.personRepository = personRepository;
        this.languageService = languageService;
    }

    public List<PersonDto> allPersons() {
        return personRepository.findAll().stream()
                .map(PersonDto::fromPerson)
                .toList();
    }

    public int addPerson(PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.name().split(" ")[0]);
        person.setLastName(personDto.name().split(" ")[1]);
        person.setProgrammer(personDto.programmer());
        person = personRepository.save(person);
        return person.getId();
    }

    public List<PersonWithSocialMedia> allPersonsWithSocialMedia() {
        return personRepository.findAll().stream()
                .map(PersonWithSocialMedia::fromPerson)
                .toList();
    }

    @Transactional
    public void addLanguages(int personId, List<String> languages) {
        Person person = personRepository.findById(personId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Person not found"));
        languages.stream()
                .map(languageService::getLanguageOrCreate)
                .forEach(person::addLanguage);
        personRepository.save(person);
    }
}
