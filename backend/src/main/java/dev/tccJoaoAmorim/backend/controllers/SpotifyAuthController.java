package dev.tccJoaoAmorim.backend.controllers;

import dev.tccJoaoAmorim.backend.services.SpotifyAuthService;
import dev.tccJoaoAmorim.backend.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auth")
public class SpotifyAuthController {

    private final SpotifyAuthService spotifyAuthService;

    @Autowired
    public SpotifyAuthController(SpotifyAuthService spotifyAuthService, TokenService tokenService) {
        this.spotifyAuthService = spotifyAuthService;
    }

    @GetMapping("/spotify/login")
    public RedirectView spotifyLogin() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(this.spotifyAuthService.getAuthCode());
        return redirectView;
    }

    // Após a autorização, o Spotify redirecionará de volta para este URI com o código de autorização
    @GetMapping("/spotify/callback")
    public RedirectView getAccessToken(@RequestParam("code") String code) {
        this.spotifyAuthService.getAccessToken(code);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200");

        return redirectView;
    }

}
