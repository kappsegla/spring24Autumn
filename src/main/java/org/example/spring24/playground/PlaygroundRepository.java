package org.example.spring24.playground;

import org.example.spring24.entity.Playground;
import org.springframework.data.repository.ListCrudRepository;

public interface PlaygroundRepository extends ListCrudRepository<Playground, Integer> {
}
