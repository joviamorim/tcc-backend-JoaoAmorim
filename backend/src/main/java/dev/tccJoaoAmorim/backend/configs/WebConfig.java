package dev.tccJoaoAmorim.backend.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todos os endpoints
                .allowedOrigins("http://localhost:4200", "https://accounts.spotify.com/authorize") // Origem permitida
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite qualquer cabeçalho
                .allowCredentials(true) // Permite envio de cookies e credenciais
                .maxAge(3600); // Tempo de cache da política (em segundos)
    }
}
