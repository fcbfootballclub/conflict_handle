package com.example.securityagain.users_and_roles.dto;

import lombok.Getter;

@Getter
public class LoginDTO {
    private String userNameOrEmail;
    private String password;
}
