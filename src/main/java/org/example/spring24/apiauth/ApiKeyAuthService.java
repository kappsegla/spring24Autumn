package org.example.spring24.apiauth;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class ApiKeyAuthService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyAuthService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public Optional<String> isValidApiKey(String apiKey) {
        if( apiKey != null && !apiKey.isEmpty()) {
            var key = apiKeyRepository.findByApiKey(apiKey);
            if( key.isPresent() && key.get().getValidUntil().isAfter(LocalDateTime.now().toInstant(ZoneOffset.UTC))) {
                return Optional.of(key.get().getName());
            }
        }
        return Optional.empty();
    }
}
