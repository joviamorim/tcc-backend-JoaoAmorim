package dev.tccJoaoAmorim.backend.controllers;

import dev.tccJoaoAmorim.backend.services.SpotifyAuthService;
import dev.tccJoaoAmorim.backend.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auth")
public class SpotifyAuthController {

    private final SpotifyAuthService spotifyAuthService;
    private final UserService userService;

    public SpotifyAuthController(SpotifyAuthService spotifyAuthService, UserService userService) {
        this.spotifyAuthService = spotifyAuthService;
        this.userService = userService;
    }

    @GetMapping("/spotify/login")
    public RedirectView spotifyLogin() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(this.spotifyAuthService.getAuthCode());
        return redirectView;
    }

    // Após a autorização, o Spotify redirecionará de volta para este URI com o código de autorização
    // att: estou mudando para enviar o jwtToken gerado ao invés do accessToken do spotify
    @GetMapping("/spotify/callback")
    public RedirectView getAccessToken(@RequestParam("code") String code, HttpServletRequest request) {
        String accessToken = this.spotifyAuthService.getAccessToken(code);
        String userId = this.userService.getUserInfo(accessToken).getId();
        String jwtToken = this.spotifyAuthService.getJwtToken(accessToken, userId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/spotify/callback?token=" + jwtToken);
        //return ResponseEntity.ok(jwtToken);
        return redirectView;
    }

}
