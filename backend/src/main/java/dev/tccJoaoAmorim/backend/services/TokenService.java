package dev.tccJoaoAmorim.backend.services;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
