package org.example.spring24.playground;

import org.example.spring24.entity.Playground;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class PlayGroundController {

    private final PlaygroundService playgroundService;

    public PlayGroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @GetMapping("/playgrounds")
    public List<Playground> allPlaygrounds() {
        return playgroundService.all();
    }

    @PostMapping("/playgrounds")
    public ResponseEntity<Void> addPlayground(@RequestParam float lat,
                                              @RequestParam float lon) {
        Playground p = playgroundService.createNewPlayGround(lat, lon);
        return ResponseEntity.created(URI.create("/playgrounds/" + p.getId())).build();
    }
}
