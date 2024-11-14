package org.example.spring24.language;

import org.example.spring24.entity.LanguageEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

interface LanguageRepository extends ListCrudRepository<LanguageEntity, Integer> {

    Optional<LanguageEntity> findByName(String name);
}
