package xyz.victorl.scrontch.users.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.refreshexpiration}")
    private Long refreshExpiration;

    // Generate the SecretKey using the secret string
    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // Extract username from token
    public String extractUsername(String token) {
        try {
            return Jwts.parser()  // Use parserBuilder to avoid deprecated methods
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            return null;  // Return null if token is invalid
        }
    }

    // Generate Access Token
    public String generateToken(String username, String role) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);  // Expiration for Access Token
        SecretKey key = getSecretKey();

        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256)  // Correct usage of SignatureAlgorithm
                .compact();
    }

    // Generate Refresh Token
    public String generateRefreshToken(String username) {
        Date expirationDate = new Date(System.currentTimeMillis() + refreshExpiration);  // Expiration for Refresh Token
        SecretKey key = getSecretKey();

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256)  // Correct usage of SignatureAlgorithm
                .compact();
    }

    // Validate Token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()  // Use parserBuilder instead of deprecated methods
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token);  // Parse the claims
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;  // Token is invalid or expired
        }
    }

    // Validate Refresh Token
    public boolean validateRefreshToken(String refreshToken) {
        try {
            Jwts.parser()  // Use parserBuilder to avoid deprecated methods
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(refreshToken);  // Parse the claims for refresh token
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;  // Refresh token is invalid or expired
        }
    }

    // Check if token is expired
    public boolean isTokenExpired(String token) {
        try {
            Date expiration = Jwts.parser()  // Use parserBuilder instead of deprecated methods
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());  // Check if the token is expired
        } catch (JwtException e) {
            return true;  // If there's any issue, consider it expired
        }
    }

    // Check if Refresh Token is expired
    public boolean isRefreshTokenExpired(String refreshToken) {
        try {
            Date expiration = Jwts.parser()  // Use parserBuilder to avoid deprecated methods
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(refreshToken)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());  // Check if the refresh token is expired
        } catch (JwtException e) {
            return true;  // If there's any issue, consider it expired
        }
    }
}
