package org.example.spring24.apiauth;

import org.springframework.stereotype.Service;

@Service
public class ApiKeyAuthService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyAuthService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public boolean isValidApiKey(String apiKey) {
        if( apiKey != null && !apiKey.isEmpty() && apiKey.equals("A123B")) {
            return true;
        }
        return false;//apiKeyRepository.existsByApiKey(apiKey);
    }
}
