package com.guidejourney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidejourney.model.entities.Mentor;
import com.guidejourney.model.enums.MentorStatus;
import com.guidejourney.repositories.MentorRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private MentorRepository mentorRepository;

    public List<Mentor> getPendingMentors() {
        return mentorRepository.findAll();
    }

    public void approveMentor(Long mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId).orElseThrow(() -> new RuntimeException("Mentor not found"));
        mentor.setStatus(MentorStatus.APPROVED);
        mentorRepository.save(mentor);
    }

    public void rejectMentor(Long mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId).orElseThrow(() -> new RuntimeException("Mentor not found"));
        mentor.setStatus(MentorStatus.REJECTED);
        mentorRepository.save(mentor);
    }
}
