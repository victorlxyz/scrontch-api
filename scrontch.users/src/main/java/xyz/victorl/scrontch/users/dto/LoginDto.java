package xyz.victorl.scrontch.users.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {
    private String usernameOrEmail;
    private String password;
}
