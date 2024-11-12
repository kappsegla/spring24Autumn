package org.example.spring24.language.api;

public interface LanguageService {
    Language getLanguageOrCreate(String languageName);
}
