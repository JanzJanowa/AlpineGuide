package com.alpineguide.services;

import com.alpineguide.entities.Trail;
import com.alpineguide.repositories.TrailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailService {

    private final TrailRepository trailRepository;

    public TrailService(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    public List<Trail> getAllTrails() {
        return trailRepository.findAll();
    }

    public Trail getTrailById(Long id) {
        return trailRepository.findById(id).orElse(null);
    }

    public Trail createTrail(Trail trail) {
        return trailRepository.save(trail);
    }

    public Trail updateTrail(Trail trail) {
        return trailRepository.save(trail);
    }

    public void deleteTrail(Long id) {
        trailRepository.deleteById(id);
    }

}
