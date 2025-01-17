package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.JwtResponse;
import xyz.victorl.scrontch.users.dto.LoginDto;
import xyz.victorl.scrontch.users.dto.UserRegistrationDto;

public interface AuthService {
    void register(UserRegistrationDto registrationDto);
    JwtResponse login(LoginDto loginDto);

    boolean verifyEmail(String token);

    public JwtResponse refreshToken(String refreshToken);
}
