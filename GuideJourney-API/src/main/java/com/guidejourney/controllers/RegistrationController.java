package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.ProfileSelectionDTO;
import com.guidejourney.model.dto.MentorProfileDTO;
import com.guidejourney.model.dto.StudentProfileDTO;
import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.dto.UserResponseDTO;
import com.guidejourney.services.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserResponseDTO registeredUser = registrationService.registerUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/select-profile")
    public ResponseEntity<String> selectProfile(@RequestBody ProfileSelectionDTO profileSelectionDTO, Authentication authentication) {
        String email = authentication.getName();
        registrationService.selectProfile(email, profileSelectionDTO);
        return ResponseEntity.ok("Perfil seleccionado");
    }

    @PostMapping("/student")
    public ResponseEntity<String> completeStudentProfile(@RequestBody StudentProfileDTO studentProfileDTO) {
        registrationService.completeStudentProfile(studentProfileDTO);
        return ResponseEntity.ok("Registro de estudiante completado");
    }

    @PostMapping("/mentor")
    public ResponseEntity<String> completeMentorProfile(@RequestBody MentorProfileDTO mentorProfileDTO) {
        registrationService.completeMentorProfile(mentorProfileDTO);
        return ResponseEntity.ok("Registro de mentor enviado para aprobación");
    }
}
