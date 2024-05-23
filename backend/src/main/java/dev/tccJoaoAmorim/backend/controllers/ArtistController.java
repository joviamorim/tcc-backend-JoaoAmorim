package dev.tccJoaoAmorim.backend.controllers;

import dev.tccJoaoAmorim.backend.models.TopArtists;
import dev.tccJoaoAmorim.backend.services.ArtistService;
import dev.tccJoaoAmorim.backend.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/top")
    public TopArtists getUserTopArtists() {
        return artistService.getUserTopArtists();
    }



}
