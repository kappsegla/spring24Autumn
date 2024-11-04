package org.example.spring24.person;

import org.example.spring24.person.entity.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonRepository extends ListCrudRepository<Person, Integer> {
}
