package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.infra.security.JwtTokenService;
import dev.tccJoaoAmorim.backend.models.TopArtists;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistService {

    @Autowired
    private final TokenService tokenService;
    private final JwtTokenService jwtTokenService;

    public ArtistService(TokenService tokenService, JwtTokenService jwtTokenService) {
        this.tokenService = tokenService;
        this.jwtTokenService = jwtTokenService;
    }

    public TopArtists getUserTopArtists(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();

        String accessToken = jwtTokenService.getJwtAccessToken(request.getHeader("Authorization"));

        headers.set("Authorization", accessToken);
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
