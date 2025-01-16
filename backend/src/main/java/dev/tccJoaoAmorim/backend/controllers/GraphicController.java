package dev.tccJoaoAmorim.backend.controllers;

import dev.tccJoaoAmorim.backend.models.Artist;
import dev.tccJoaoAmorim.backend.models.Track;
import dev.tccJoaoAmorim.backend.models.TrackFeatures;
import dev.tccJoaoAmorim.backend.services.GraphicService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/graphic")
public class GraphicController {

    private final GraphicService graphicService;

    @Autowired
    public GraphicController(GraphicService graphicService) {
        this.graphicService = graphicService;
    }

    @GetMapping("/teste")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/testeErro")
    public String helloWorldErro() {
        return "Hello, World! Errado.";
    }

    @GetMapping("/track/popularity/top")
    public List<Track> getTopTracksWithPopularity(HttpServletRequest request) {
        return graphicService.getTopTracksWithPopularity(request);
    }

    @GetMapping("/track/features/top")
    public ArrayList<TrackFeatures> getTopTracksWithFeatures(HttpServletRequest request) {
        return graphicService.getTopTracksWithFeatures(request);
    }

    @GetMapping("/artist/popularity/top")
    public List<Artist> topPopularityArtists(HttpServletRequest request) {
        return graphicService.getTopArtistsByPopularity(request);
    }
}
