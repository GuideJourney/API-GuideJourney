package com.guidejourney.model.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;

import com.guidejourney.model.enums.MentorStatus;

@Data
@Entity
@Table(name = "mentors")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileImage;
    private String name;
    private String country;
    private String workplace;
    private int yearsExperience;
    private String linkedinUrl;

    @ElementCollection
    private Set<String> workAreas;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private MentorStatus status;
}
