package xyz.victorl.scrontch.ingredient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class IngredientSecurityConfiguration {

    @Bean
    public SecurityFilterChain ingredientFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(c ->c.configurationSource(ingredientCorsConfigurationSource()))
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers("/api/**")
                );
        return http.build();
    }

    @Bean
    CorsConfigurationSource ingredientCorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

