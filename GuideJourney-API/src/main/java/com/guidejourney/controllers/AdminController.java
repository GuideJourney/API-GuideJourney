package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.entities.Mentor;
import com.guidejourney.services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/mentor-requests")
    public List<Mentor> getPendingMentors() {
        return adminService.getPendingMentors();
    }

    @PostMapping("/approve-mentor")
    public String approveMentor(@RequestParam Long mentorId) {
        adminService.approveMentor(mentorId);
        return "Mentor aprobado";
    }

    @PostMapping("/reject-mentor")
    public String rejectMentor(@RequestParam Long mentorId) {
        adminService.rejectMentor(mentorId);
        return "Mentor rechazado";
    }
}

