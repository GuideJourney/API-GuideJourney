package com.guidejourney.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guidejourney.model.dto.UserRegistrationDto;
import com.guidejourney.model.dto.UserResponseDto;
import com.guidejourney.model.entities.User;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public User toEntity(UserRegistrationDto userRegistrationDto) {
        return modelMapper.map(userRegistrationDto, User.class);
    }

    public UserResponseDto toDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }
}
