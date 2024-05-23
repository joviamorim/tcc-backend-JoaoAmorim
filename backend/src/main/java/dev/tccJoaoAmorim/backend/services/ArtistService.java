package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.TopArtists;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistService {

    private final TokenService tokenService;

    public ArtistService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public TopArtists getUserTopArtists() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", tokenService.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TopArtists> responseArtists = restTemplate.exchange(
                "https://api.spotify.com/v1/me/top/artists?limit=5",
                HttpMethod.GET,
                entity,
                TopArtists.class
        );
        return responseArtists.getBody();
    }

}
