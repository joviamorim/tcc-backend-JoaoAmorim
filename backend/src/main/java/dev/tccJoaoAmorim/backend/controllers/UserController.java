package dev.tccJoaoAmorim.backend.controllers;

import dev.tccJoaoAmorim.backend.models.User;
import dev.tccJoaoAmorim.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/info")
    public User getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        // Extrair o token de acesso do cabeçalho de autorização
        //String accessToken = authorizationHeader.replace("Bearer ", "");

        //return userService.getUserInfo(accessToken);
        return userService.getUserInfo(authorizationHeader);
    }
}
