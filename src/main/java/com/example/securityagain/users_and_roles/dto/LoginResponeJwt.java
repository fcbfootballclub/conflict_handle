package com.example.securityagain.users_and_roles.dto;

import lombok.Data;

@Data
public class LoginResponeJwt {
    private String token;
    private String type;
    public LoginResponeJwt(String token) {
        this.token = token;
        this.type = "Bearer";
    }
}
