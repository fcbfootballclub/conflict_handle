package com.example.securityagain.users_and_roles.controller;

import com.example.securityagain.users_and_roles.dto.LoginDTO;
import com.example.securityagain.users_and_roles.dto.SignupDTO;
import com.example.securityagain.users_and_roles.repository.RoleRepository;
import com.example.securityagain.users_and_roles.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/auth")
@CrossOrigin
public class AuthenController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserNameOrEmail(), loginDTO.getPassword()));
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("Sign in successfully!");
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody SignupDTO signupDTO) {
        return ResponseEntity.ok("Sign up successfully!");
    }

}
