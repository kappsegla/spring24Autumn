package org.example.spring24.person;

import org.example.spring24.person.dto.PersonDto;
import org.example.spring24.person.dto.PersonWithSocialMedia;
import org.example.spring24.person.entity.Person;
import org.example.spring24.person.entity.SocialMedia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
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

}
