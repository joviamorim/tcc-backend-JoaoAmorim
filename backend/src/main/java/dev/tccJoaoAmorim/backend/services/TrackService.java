package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.infra.security.JwtTokenService;
import dev.tccJoaoAmorim.backend.models.TopTracks;
import dev.tccJoaoAmorim.backend.models.TrackFeatures;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrackService {

    private final TokenService tokenService;
    private final JwtTokenService jwtTokenService;

    public TrackService(TokenService tokenService, JwtTokenService jwtTokenService) {
        this.tokenService = tokenService;
        this.jwtTokenService = jwtTokenService;
    }

    public TopTracks getUserTopTracks(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();

        String accessToken = jwtTokenService.getJwtAccessToken(request.getHeader("Authorization"));

        headers.set("Authorization", accessToken);
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

    public TrackFeatures getTrackFeatures(String id, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        String accessToken = jwtTokenService.getJwtAccessToken(request.getHeader("Authorization"));

        headers.set("Authorization", accessToken);
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
}
