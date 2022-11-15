package com.example.securityagain;

import com.example.securityagain.users_and_roles.entity.Role;
import com.example.securityagain.users_and_roles.entity.RoleEnum;
import com.example.securityagain.users_and_roles.entity.Users;
import com.example.securityagain.users_and_roles.repository.RoleRepository;
import com.example.securityagain.users_and_roles.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.UUID;

@SpringBootApplication
public class SecurityAgainApplication implements CommandLineRunner {
    @Autowired private UsersRepository usersRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityAgainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Users user = Users.
                builder()
                .userId(UUID.randomUUID())
                .email("dinhluyen45@gmail")
                .password(passwordEncoder.encode("123456"))
                .userName("dinhluyen")
                .build();
        Role role = Role.builder()
                .roleId(UUID.randomUUID())
                .roleTitle(RoleEnum.admin)
                .build();
        user.setRoleSet(Collections.singleton(role));
        roleRepository.save(role);
        usersRepository.save(user);
    }
}
1
2
3
4
5
6
7
8
9
10
