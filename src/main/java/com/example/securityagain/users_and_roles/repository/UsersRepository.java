package com.example.securityagain.users_and_roles.repository;

import com.example.securityagain.users_and_roles.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findUsersByUserNameOrEmail(String userName, String email);
    Users findUsersByUserName(String userName);
    Users findUsersByEmail(String email);
    boolean existsByUserNameOrEmail(String userName, String email);
}
