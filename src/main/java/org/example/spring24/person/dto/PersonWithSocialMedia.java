package org.example.spring24.person.dto;

import org.example.spring24.entity.PersonEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record PersonWithSocialMedia(String name, Set<SocialMediaDto> socialMedias) {
    public static PersonWithSocialMedia fromPerson(PersonEntity person) {
        return new PersonWithSocialMedia(person.getFullName(),
                person.getSocialMedias().stream().map(SocialMediaDto::from)
                        .collect(Collectors.toSet()));
    }
}
