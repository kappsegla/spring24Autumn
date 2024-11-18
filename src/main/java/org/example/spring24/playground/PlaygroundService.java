package org.example.spring24.playground;

import org.example.spring24.entity.Playground;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {
    private final PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository) {
        this.playgroundRepository = playgroundRepository;
    }

    public List<Playground> all() {
        return playgroundRepository.findAll();
    }
}
