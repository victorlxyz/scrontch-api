package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.victorl.scrontch.users.dto.JwtResponse;
import xyz.victorl.scrontch.users.dto.LoginDto;
import xyz.victorl.scrontch.users.dto.UserRegistrationDto;
import xyz.victorl.scrontch.users.entity.Role;
import xyz.victorl.scrontch.users.entity.Status;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.repository.RoleRepository;
import xyz.victorl.scrontch.users.repository.StatusRepository;
import xyz.victorl.scrontch.users.repository.UserRepository;
import xyz.victorl.scrontch.users.service.AuthService;
import xyz.victorl.scrontch.users.utils.JwtUtils;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

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
        userRepository.save(user);
    }

    @Override
    public JwtResponse login(LoginDto loginDto) {
        User user = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Invalid username or email"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPasswordhash())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtils.generateToken(user.getUsername(), user.getRoleid().getName());
        return new JwtResponse(token, user.getUsername(), user.getEmail(), user.getRoleid().getName());
    }
}

