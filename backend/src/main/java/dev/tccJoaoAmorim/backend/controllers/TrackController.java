package dev.tccJoaoAmorim.backend.controllers;

import dev.tccJoaoAmorim.backend.models.TopTracks;
import dev.tccJoaoAmorim.backend.models.TrackFeatures;
import dev.tccJoaoAmorim.backend.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController {
    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/features/{id}")
    public TrackFeatures getTrackFeatures(@PathVariable String id) {
        return trackService.getTrackFeatures(id);
    }

    @GetMapping("/top")
    public TopTracks getUserTopTracks() {
        return trackService.getUserTopTracks();
    }
}
