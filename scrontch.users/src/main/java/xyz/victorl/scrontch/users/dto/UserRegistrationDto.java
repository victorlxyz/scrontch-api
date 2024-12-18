package xyz.victorl.scrontch.users.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegistrationDto implements Serializable {
    private String username;
    private String email;
    private String password;
}
