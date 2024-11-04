package org.example.spring24.person;

import org.example.spring24.person.entity.Person;

public record PersonDto(String name, boolean programmer) {

    public static PersonDto fromPerson(Person person) {
        return new PersonDto(person.getName(), person.getProgrammer());
    }
}
