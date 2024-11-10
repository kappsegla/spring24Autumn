package org.example.spring24.language;

import org.example.spring24.person.entity.Language;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface LanguageRepository extends ListCrudRepository<Language, Integer> {

    Optional<Language> findByName(String name);


}
