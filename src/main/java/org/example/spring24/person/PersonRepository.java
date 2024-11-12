package org.example.spring24.person;

import org.example.spring24.person.entity.PersonEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonRepository extends ListCrudRepository<PersonEntity, Integer> {
}
