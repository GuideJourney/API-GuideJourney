package com.guidejourney.model.entities;

import lombok.Data;

import com.guidejourney.model.enums.ProfileType;
import com.guidejourney.model.enums.Role;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @Enumerated(EnumType.STRING)
    private ProfileType profileType;
}
