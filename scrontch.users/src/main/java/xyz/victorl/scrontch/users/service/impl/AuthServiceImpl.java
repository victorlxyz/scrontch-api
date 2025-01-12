package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.victorl.scrontch.users.dto.JwtResponse;
import xyz.victorl.scrontch.users.dto.LoginDto;
import xyz.victorl.scrontch.users.dto.UserRegistrationDto;
import xyz.victorl.scrontch.users.entity.EmailVerificationToken;
import xyz.victorl.scrontch.users.entity.Role;
import xyz.victorl.scrontch.users.entity.Status;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.repository.EmailVerificationTokenRepository;
import xyz.victorl.scrontch.users.repository.RoleRepository;
import xyz.victorl.scrontch.users.repository.StatusRepository;
import xyz.victorl.scrontch.users.repository.UserRepository;
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
        String verificationUrl = "http://localhost:8086/api/v1/auth/verify-email?token=" + token;

        // Use EmailNotificationService to send verification email
        emailNotificationService.sendAccountVerificationEmail(user, verificationUrl);
    }

    @Override
    public JwtResponse login(LoginDto loginDto) {
        User user = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Invalid username or email"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPasswordhash())) {
            throw new RuntimeException("Invalid password");
        }

        if (!user.getEmailVerified()) {
            throw new RuntimeException("Email not verified. Please verify your email before logging in.");
        }

        String token = jwtUtils.generateToken(user.getUsername(), user.getRoleid().getName());
        return new JwtResponse(token, user.getUsername(), user.getEmail(), user.getRoleid().getName());
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
        System.out.println("Invalid or expired token");
        return false;
    }

}
