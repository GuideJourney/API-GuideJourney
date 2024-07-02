package com.guidejourney.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guidejourney.model.dto.MentorProfileDTO;
import com.guidejourney.model.dto.StudentProfileDTO;
import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.entities.Mentor;
import com.guidejourney.model.entities.Student;
import com.guidejourney.model.entities.User;

@Component
public class ProfileMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public Mentor convertToEntity(MentorProfileDTO mentorProfileDTO) {
        return modelMapper.map(mentorProfileDTO, Mentor.class);
    }

    public Student convertToEntity(StudentProfileDTO studentProfileDTO) {
        return modelMapper.map(studentProfileDTO, Student.class);
    }
}
