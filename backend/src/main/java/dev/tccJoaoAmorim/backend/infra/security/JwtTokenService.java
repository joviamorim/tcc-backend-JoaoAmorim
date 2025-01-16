package dev.tccJoaoAmorim.backend.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtTokenService {

    @Value("${jwt.token.secret}")
    private String secret;

    public String generateToken(String accessToken, String userId) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("backend-tcc")
                    .withSubject(userId)
                    .withClaim("accessToken", accessToken)
                    .withExpiresAt(generateExpirationDate())
                    .withIssuedAt(Instant.now())
                    .sign(algorithm);
            return token;
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error while generating token: " + exception);
        }
    }

    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("backend-tcc")
                    .build()
                    .verify(token);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Error while validating token: " + exception);
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getJwtAccessToken(String jwtToken) {
        String jwt = jwtToken.replace("Bearer ", "");

        // Primeiro valida o token
        DecodedJWT decodedJWT = validateToken(jwt);

        // Retorna o accessToken do claim
        return decodedJWT.getClaim("accessToken").asString();
    }
}
