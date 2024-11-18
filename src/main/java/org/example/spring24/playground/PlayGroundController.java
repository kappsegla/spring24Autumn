package org.example.spring24.playground;

import org.example.spring24.entity.Playground;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlayGroundController {

    private final PlaygroundService playgroundService;

    public PlayGroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @GetMapping("/playgrounds")
    public List<Playground> allPlaygrounds() {
        return playgroundService.all();
    }
}
