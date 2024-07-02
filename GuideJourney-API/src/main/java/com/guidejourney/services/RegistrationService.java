package com.guidejourney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.mapper.ProfileMapper;
import com.guidejourney.model.ProfileSelectionDTO;
import com.guidejourney.model.dto.MentorProfileDTO;
import com.guidejourney.model.dto.StudentProfileDTO;
import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.dto.UserResponseDTO;
import com.guidejourney.model.entities.Mentor;
import com.guidejourney.model.entities.Student;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.MentorStatus;
import com.guidejourney.model.enums.ProfileType;
import com.guidejourney.repositories.MentorRepository;
import com.guidejourney.repositories.StudentRepository;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfileMapper profileMapper;

    public UserResponseDTO registerUser(UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    public void selectProfile(String email, ProfileSelectionDTO profileSelectionDTO) {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        if ("STUDENT".equalsIgnoreCase(profileSelectionDTO.getProfileType())) {
            user.setProfileType(ProfileType.STUDENT);
        } else if ("MENTOR".equalsIgnoreCase(profileSelectionDTO.getProfileType())) {
            user.setProfileType(ProfileType.MENTOR);
        }
        userService.save(user);
    }

    public void completeStudentProfile(StudentProfileDTO studentProfileDTO) {
        Student student = profileMapper.convertToEntity(studentProfileDTO);
        studentRepository.save(student);
    }

    public void completeMentorProfile(MentorProfileDTO mentorProfileDTO) {
        Mentor mentor = profileMapper.convertToEntity(mentorProfileDTO);
        mentor.setStatus(MentorStatus.PENDING);
        mentorRepository.save(mentor);
    }
}
