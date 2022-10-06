package com.example.securityagain.users_and_roles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "role")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "role_title", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleTitle;

    @ManyToMany(mappedBy = "roleSet")
    @JsonIgnore
    @ToString.Exclude
    private Set<Users> usersSet;

    public String getRoleTitle() {
        return roleTitle.toString();
    }
}
