package org.example.spring24.person;

import org.example.spring24.person.entity.Person;
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
        person.setName(personDto.name());
        person.setProgrammer(personDto.programmer());
        person = personRepository.save(person);
        return person.getId();
    }
}
