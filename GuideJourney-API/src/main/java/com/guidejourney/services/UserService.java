package com.guidejourney.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.dto.UserResponseDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.ProfileType;
import com.guidejourney.model.enums.Role;
import com.guidejourney.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDTO registerUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        // Establecer valores por defecto para profileType y role si no se han establecido
        if (user.getProfileType() == null) {
            user.setProfileType(ProfileType.UNASSIGNED);
        }
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
