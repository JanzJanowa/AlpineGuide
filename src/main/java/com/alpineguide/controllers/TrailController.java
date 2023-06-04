package com.alpineguide.controllers;

import com.alpineguide.entities.Trail;
import com.alpineguide.services.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trails")
public class TrailController {
    private final TrailService trailService;

    @Autowired
    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @GetMapping
    public ResponseEntity<List<Trail>> getAllTrails() {
        List<Trail> trails = trailService.getAllTrails();
        return ResponseEntity.ok(trails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trail> getTrailById(@PathVariable Long id) {
        return Optional.ofNullable(trailService.getTrailById(id)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Trail> createTrail(@RequestBody Trail trail) {
        Trail savedTrail = trailService.createTrail(trail);
        return ResponseEntity.ok(savedTrail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trail> updateTrail(@PathVariable Long id, @RequestBody Trail trail) {
        Optional<Trail> existingTrail = Optional.ofNullable(trailService.getTrailById(id));
        if (existingTrail.isPresent()) {
            Trail updatedTrail = trailService.updateTrail(trail);
            return ResponseEntity.ok(updatedTrail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrail(@PathVariable Long id) {
        trailService.deleteTrail(id);
        return ResponseEntity.noContent().build();
    }
}
