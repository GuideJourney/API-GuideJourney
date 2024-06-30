package com.guidejourney.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminUserConfig adminUserConfig;

    @PostConstruct
    public void init() {
        if (!userRepository.findByEmail(adminUserConfig.getEmail()).isPresent()) {
            User adminUser = new User();
            adminUser.setEmail(adminUserConfig.getEmail());
            adminUser.setPassword(passwordEncoder.encode(adminUserConfig.getPassword()));
            adminUser.setRole(adminUserConfig.getRole());
            userRepository.save(adminUser);
        }
    }
}
