package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.victorl.scrontch.users.dto.JwtResponse;
import xyz.victorl.scrontch.users.dto.LoginDto;
import xyz.victorl.scrontch.users.dto.UserRegistrationDto;
import xyz.victorl.scrontch.users.entity.EmailVerificationToken;
import xyz.victorl.scrontch.common.entity.Role;
import xyz.victorl.scrontch.common.entity.Status;
import xyz.victorl.scrontch.common.entity.User;
import xyz.victorl.scrontch.users.repository.EmailVerificationTokenRepository;
import xyz.victorl.scrontch.users.repository.RoleRepository;
import xyz.victorl.scrontch.users.repository.StatusRepository;
import xyz.victorl.scrontch.common.repository.UserRepository;
import xyz.victorl.scrontch.users.service.AuthService;
import xyz.victorl.scrontch.users.service.EmailNotificationService;
import xyz.victorl.scrontch.users.utils.JwtUtils;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;
    private final EmailVerificationTokenRepository emailVerificationTokenRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final EmailNotificationService emailNotificationService;

    @Override
    public void register(UserRegistrationDto registrationDto) {
        if (userRepository.existsByEmail(registrationDto.getEmail()) ||
                userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new RuntimeException("Username or email already exists");
        }

        Role userRole = roleRepository.findByName("User")
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));

        Status activeStatus = statusRepository.findByName("Active")
                .orElseThrow(() -> new RuntimeException("Default status ACTIVE not found"));

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPasswordhash(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRoleid(userRole);
        user.setStatusid(activeStatus);
        user.setCreatedat(Instant.now());
        user.setEmailVerified(false);
        userRepository.save(user);

        // Generate and save the email verification token
        String token = UUID.randomUUID().toString();
        EmailVerificationToken verificationToken = new EmailVerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(Instant.now().plusSeconds(86400)); // 24-hour expiration
        emailVerificationTokenRepository.save(verificationToken);

        // Build verification URL
        String verificationUrl = "https://victorl.xyz:8086/api/v1/auth/verify-email?token=" + token;

        // Use EmailNotificationService to send verification email
        emailNotificationService.sendAccountVerificationEmail(user, verificationUrl);
    }

    @Override
    public JwtResponse login(LoginDto loginDto) {
        User user = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Nom d'utilisateur ou mot de passe incorrect"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPasswordhash())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        if (!user.getEmailVerified()) {
            throw new RuntimeException("Vous n'avez pas vérifié votre adresse email. Vérifiez votre email avant de continuer.");
        }

        user.setLastloginat(Instant.now());
        userRepository.save(user);

        String accessToken = jwtUtils.generateToken(user.getUsername(), user.getRoleid().getName());
        String refreshToken = jwtUtils.generateRefreshToken(user.getUsername());

        return new JwtResponse(accessToken, user.getUsername(), user.getEmail(), user.getRoleid().getName(), user.getId(), refreshToken);
    }

    @Override
    public boolean verifyEmail(String token) {
        EmailVerificationToken verificationToken = emailVerificationTokenRepository.findByToken(token);
        if (verificationToken != null && verificationToken.getExpiryDate().isAfter(Instant.now())) {
            User user = verificationToken.getUser();
            user.setEmailVerified(true);
            userRepository.save(user);
            // Delete the verification token since it's no longer needed
            emailVerificationTokenRepository.deleteById(verificationToken.getId());
            // Send confirmation email
            emailNotificationService.sendAccountValidationEmail(user);
            System.out.println("User verified: " + user.getUsername());
            return true;
        }
        throw new RuntimeException("Token expiré ou invalide");
    }

    @Override
    public JwtResponse refreshToken(String refreshToken) {
        if (!jwtUtils.validateToken(refreshToken)) {
            throw new RuntimeException("Invalid refresh token");
        }

        String username = jwtUtils.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String newAccessToken = jwtUtils.generateToken(user.getUsername(), user.getRoleid().getName());
        String newRefreshToken = jwtUtils.generateRefreshToken(user.getUsername());
        return new JwtResponse(newAccessToken, user.getUsername(), user.getEmail(), user.getRoleid().getName(), user.getId(), newRefreshToken);
    }


}
