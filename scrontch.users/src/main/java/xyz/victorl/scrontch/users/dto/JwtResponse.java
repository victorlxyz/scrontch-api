package xyz.victorl.scrontch.users.dto;

import lombok.Value;

@Value
public class JwtResponse {
    String token;
    String username;
    String email;
    String role;
    Integer userid;
}
