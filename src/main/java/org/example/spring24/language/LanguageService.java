package org.example.spring24.language;

import org.example.spring24.person.entity.Language;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public Language getLanguageOrCreate(String languageName) {
        return repository.findByName(languageName)
                .orElseGet(() -> repository.save(new Language(languageName)));
    }
}
