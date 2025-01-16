package dev.tccJoaoAmorim.backend.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null) {
            var decodedJWT = this.jwtTokenService.validateToken(token);
            String userId = decodedJWT.getSubject();
            String accessToken = decodedJWT.getClaim("accessToken").asString();

            var authentication = new UsernamePasswordAuthenticationToken(
                    userId, // Identificador do usuário (principal)
                    null,          // Sem credenciais
                    Collections.emptyList() // Authorities podem ser vazias
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Adiciona ao request
            request.setAttribute("spotifyAccessToken", accessToken);
            request.setAttribute("userId", userId);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
