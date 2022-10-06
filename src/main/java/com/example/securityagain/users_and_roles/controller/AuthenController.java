package com.example.securityagain.users_and_roles.controller;

import com.example.securityagain.users_and_roles.dto.LoginDTO;
import com.example.securityagain.users_and_roles.dto.LoginResponeJwt;
import com.example.securityagain.users_and_roles.dto.SignupDTO;
import com.example.securityagain.users_and_roles.entity.Role;
import com.example.securityagain.users_and_roles.entity.RoleEnum;
import com.example.securityagain.users_and_roles.entity.Users;
import com.example.securityagain.users_and_roles.jwt.JwtTokenProvider;
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

import java.io.UnsupportedEncodingException;
import java.util.Collections;

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
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws UnsupportedEncodingException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserNameOrEmail(), loginDTO.getPassword()));
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // get token form tokenProvider
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new LoginResponeJwt(token));
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody SignupDTO signupDTO) {
         if(usersRepository.existsByUserNameOrEmail(signupDTO.getEmail(), signupDTO.getUserName())) {
             return ResponseEntity.badRequest().body("Already signed up email or username");
         }
         Role role = roleRepository.findRolesByRoleTitle(RoleEnum.user);
        Users user = new Users().setUserName(signupDTO.getUserName())
                .setEmail(signupDTO.getEmail())
                .setPassword(passwordEncoder.encode(signupDTO.getPassword()))
                        .setRoleSet(Collections.singleton(role));
        usersRepository.save(user);
        return ResponseEntity.ok("Sign up successfully!");
    }

}
