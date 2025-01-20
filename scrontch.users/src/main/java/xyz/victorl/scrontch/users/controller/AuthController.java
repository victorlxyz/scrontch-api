package xyz.victorl.scrontch.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.users.dto.JwtResponse;
import xyz.victorl.scrontch.users.dto.LoginDto;
import xyz.victorl.scrontch.users.dto.UserRegistrationDto;
import xyz.victorl.scrontch.users.service.AuthService;
import xyz.victorl.scrontch.users.service.impl.TokenBlacklistService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final TokenBlacklistService tokenBlacklistService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDto registrationDto) {
        authService.register(registrationDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDto loginDto) {
        JwtResponse jwtResponse = authService.login(loginDto);
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        boolean isVerified = authService.verifyEmail(token);
        if (isVerified) {
            return ResponseEntity.ok("Email verified successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            tokenBlacklistService.addToBlacklist(token);
        }
        return ResponseEntity.ok("User  logged out successfully");
    }

    @PostMapping("/refresh-token")
    public JwtResponse refreshToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        return authService.refreshToken(refreshToken);
    }
}
