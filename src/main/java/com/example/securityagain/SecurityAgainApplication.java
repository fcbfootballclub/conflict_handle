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
/*        Users user = new Users()
                .setEmail("dinhluyen45@gmail")
                .setPassword(passwordEncoder.encode("123456"))
                .setUserName("dinhluyen");
//        Role role = Role.builder()
//                .roleTitle(RoleEnum.admin)
//                .build();
        Role role = roleRepository.findRolesByRoleTitle(RoleEnum.admin);
        user.setRoleSet(Collections.singleton(role));
//        roleRepository.save(role);
        usersRepository.save(user);*/
    }
}
