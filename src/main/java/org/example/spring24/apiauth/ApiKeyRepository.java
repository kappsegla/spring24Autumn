package org.example.spring24.apiauth;

import org.example.spring24.entity.ApiKey;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ApiKeyRepository extends ListCrudRepository<ApiKey,Integer> {
    Optional<ApiKey> findByApiKey(String apiKey);
}
