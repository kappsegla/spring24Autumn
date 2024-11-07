package org.example.spring24.person.dto;

import org.example.spring24.person.entity.Person;

import java.util.List;

public record PersonWithSocialMedia(String name, List<SocialMediaDto> socialMedias) {
    public static PersonWithSocialMedia fromPerson(Person person) {
        return new PersonWithSocialMedia(person.getFullName(),
                person.getSocialMedia().stream().map(SocialMediaDto::from)
                        .toList());
    }
}
