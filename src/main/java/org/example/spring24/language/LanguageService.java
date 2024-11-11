package org.example.spring24.language;

import org.example.spring24.person.entity.Language;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanguageService {

    LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Language getLanguageOrCreate(String languageName) {
        return repository.findByName(languageName)
                .orElseGet(() -> repository.save(new Language(languageName)));
    }
}
