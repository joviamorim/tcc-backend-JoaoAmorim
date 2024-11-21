package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final TokenService tokenService;

    public UserService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public User getUserInfo() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", this.tokenService.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> response = restTemplate.exchange("https://api.spotify.com/v1/me",
                HttpMethod.GET,
                entity,
                User.class
        );

        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            System.err.println("Erro ao obter o perfil do usuário do Spotify. Código de status: " + response.getStatusCode());
            return null;
        }
    }
}
