package com.guidejourney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.guidejourney.exceptions.EmailAlreadyExistsException;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.entities.Role;
import com.guidejourney.repositories.UserRepository;
import com.guidejourney.repositories.RoleRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User registerNewUser(User user, String roleName) {
        if (emailExists(user.getEmail())) {
            throw new EmailAlreadyExistsException("Correo electrónico ya en uso");
        }

        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            throw new IllegalArgumentException("Role not found");
        }

        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
