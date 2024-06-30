package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.exceptions.PasswordsDoNotMatchException;
import com.guidejourney.mapper.UserMapper;
import com.guidejourney.model.dto.UserRegistrationDto;
import com.guidejourney.model.dto.UserResponseDto;
import com.guidejourney.model.entities.User;
import com.guidejourney.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegistrationDto userDto) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new PasswordsDoNotMatchException("Las contraseñas no coinciden");
        }

        User user = userMapper.toEntity(userDto);
        User registeredUser = userService.registerNewUser(user);
        UserResponseDto responseDto = userMapper.toDto(registeredUser);
        return ResponseEntity.ok(responseDto);
    }
}
