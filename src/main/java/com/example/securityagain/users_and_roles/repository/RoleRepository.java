package com.example.securityagain.users_and_roles.repository;

import com.example.securityagain.users_and_roles.entity.Role;
import com.example.securityagain.users_and_roles.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRolesByRoleTitle(RoleEnum roleEnum);
}
