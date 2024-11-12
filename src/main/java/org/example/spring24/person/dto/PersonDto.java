package org.example.spring24.person.dto;

import org.example.spring24.person.entity.PersonEntity;

public record PersonDto(String name, boolean programmer) {

    public static PersonDto fromPerson(PersonEntity person) {
        return new PersonDto(person.getFirstName() + " " + person.getLastName(), person.getProgrammer());
    }
}
