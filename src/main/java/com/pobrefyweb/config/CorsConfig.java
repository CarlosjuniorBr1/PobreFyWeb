package com.pobrefyweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Permite requisições para todos os endpoints que começam com /api/
                .allowedOrigins("http://127.0.0.1:4200") // Permite apenas o frontend que está rodando em 127.0.0.1:4200
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite os métodos especificados
                .allowedHeaders("*"); // Permite todos os cabeçalhos
    }
}
