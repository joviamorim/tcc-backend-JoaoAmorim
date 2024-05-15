package dev.tccJoaoAmorim.backend.services;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SpotifyAuthService {

    public String getAuthCode(String clientId, String clientSecret, String redirectUri) {
        String spotifyAuthorizeUrl = "https://accounts.spotify.com/authorize";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(spotifyAuthorizeUrl)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", redirectUri)
                .queryParam("scope", "playlist-read-private playlist-read-collaborative user-read-private user-read-email");

        return builder.toUriString();
    }
    /*
    public void getAccessToken(String code) {
        // Construa o corpo da solicitação para trocar o código de autorização por um token de acesso
        String tokenUrl = "https://accounts.spotify.com/api/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret);
        String requestBody = "grant_type=authorization_code&code=" + code + "&redirect_uri=" + redirectUri;

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // Faça uma solicitação POST para trocar o código de autorização por um token de acesso
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(tokenUrl, request, TokenResponse.class);

        // Verifique se a solicitação foi bem-sucedida e obtenha o token de acesso
        if (response.getStatusCode().is2xxSuccessful()) {
            TokenResponse responseBody = response.getBody();
            // Aqui você pode analisar o corpo da resposta para extrair o token de acesso
            // e realizar outras operações, como salvar o token de acesso e redirecionar o usuário para uma página de boas-vindas.

            if(responseBody != null) {
                String accessToken = responseBody.getAccessToken();
                HttpHeaders headersUser = new HttpHeaders();
                headersUser.setBearerAuth(accessToken);
                headersUser.setContentType(MediaType.APPLICATION_JSON);

                // Configurar a entidade HTTP com os cabeçalhos
                HttpEntity<String> entity = new HttpEntity<String>(headersUser);

                ResponseEntity<User> responseUser = restTemplate.exchange("http://localhost:8080/user/info", HttpMethod.GET, entity, User.class);
                System.out.println(responseUser.getBody().getDisplayName());
            }

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("/grafic/teste");

            return;
        } else {
            // Se a solicitação falhar, você pode lidar com isso adequadamente, por exemplo, redirecionando o usuário de
            // volta para a página de login com uma mensagem de erro.

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("/grafic/testeErro");

            return;
        }
    }
    */

}
