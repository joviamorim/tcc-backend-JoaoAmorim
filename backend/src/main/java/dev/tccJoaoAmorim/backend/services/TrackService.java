package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.TopTracks;
import dev.tccJoaoAmorim.backend.models.Track;
import dev.tccJoaoAmorim.backend.models.TrackFeatures;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrackService {

    private final TokenService tokenService;

    public TrackService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public TopTracks getUserTopTracks() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", tokenService.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TopTracks> response = restTemplate.exchange(
                "https://api.spotify.com/v1/me/top/tracks?limit=10",
                HttpMethod.GET,
                entity,
                TopTracks.class
        );
        return response.getBody();
    }

    public TrackFeatures getTrackFeatures(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", tokenService.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TrackFeatures> response = restTemplate.exchange(
                "https://api.spotify.com/v1/audio-features/" + id,
                HttpMethod.GET,
                entity,
                TrackFeatures.class
        );
        return response.getBody();
    }

    public void setTrackFeatures() {}
}
