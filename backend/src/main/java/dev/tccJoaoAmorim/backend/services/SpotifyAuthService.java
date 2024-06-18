package dev.tccJoaoAmorim.backend.services;

import dev.tccJoaoAmorim.backend.configs.ClientConfig;
import dev.tccJoaoAmorim.backend.models.TokenResponse;
import dev.tccJoaoAmorim.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SpotifyAuthService {

    private final ClientConfig clientConfig;
    private final TokenService tokenService;

    @Autowired
    public SpotifyAuthService(ClientConfig clientConfig, TokenService tokenService) {
        this.clientConfig = clientConfig;
        this.tokenService = tokenService;
    }

    public String getAuthCode() {
        String spotifyAuthorizeUrl = "https://accounts.spotify.com/authorize";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(spotifyAuthorizeUrl)
                .queryParam("client_id", clientConfig.getClientId())
                .queryParam("client_secret", clientConfig.getClientSecret())
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", clientConfig.getRedirectUri())
                .queryParam("scope", "playlist-read-private " +
                        "playlist-read-collaborative " +
                        "user-read-private " +
                        "user-read-email " +
                        "user-top-read"
                );

        return builder.toUriString();
    }

    public void getAccessToken(String code) {
        // Construir o corpo da solicitação para trocar o código de autorização por um token de acesso
        String tokenUrl = "https://accounts.spotify.com/api/token";
        String requestBody = "grant_type=authorization_code&code=" +
                code +
                "&redirect_uri=" +
                clientConfig.getRedirectUri();

        // Montando o header do request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientConfig.getClientId(), clientConfig.getClientSecret());

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // Solicitação POST para trocar o código de autorização por um token de acesso
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(tokenUrl, request, TokenResponse.class);

        // Verificar se a solicitação foi bem-sucedida e obter o token de acesso
        if (response.getStatusCode().is2xxSuccessful()) {
            TokenResponse responseBody = response.getBody();

            if(responseBody != null) {
                this.tokenService.setAccessToken(responseBody.getTokenType() + " " + responseBody.getAccessToken());
            }

        } else {
            // Se a solicitação falhar, lidar de alguma forma

        }
    }

}
