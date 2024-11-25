package org.example.spring24.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TodoService {

    RestClient restClient;

    public TodoService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Retryable(maxAttempts = 2)
    public List<Todo> getTodos() {
        log.info("Sending request to remote api");
        return restClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/todos")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @Retryable(maxAttempts = 2)
    @Cacheable("todos")
    public Todo getOne(long id) {
        log.info("Sending request to remote api for id {}", id);

        return restClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/todos/" + id)
                .retrieve()
                .body(Todo.class);
    }

    @Recover
    public List<Todo> recover(Exception e) {
        log.info("Recovering after {}", e.getMessage());
        return List.of();
    }
}
