package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.models.TopTracks;
import dev.tccJoaoAmorim.backend.models.User;
import dev.tccJoaoAmorim.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {

    private final TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

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
            if(!findUserInfo(response.getBody()).equals(response.getBody())){
                saveUserInfo(response.getBody());
            }
            return response.getBody();
        } else {
            System.err.println("Erro ao obter o perfil do usuário do Spotify. Código de status: " + response.getStatusCode());
            return null;
        }
    }

    public void saveUserInfo(User obj) {
        userRepository.save(obj);
    }

    public Optional<User> findUserInfo(User obj) {
        return userRepository.findById(obj.getId());
    }

}
