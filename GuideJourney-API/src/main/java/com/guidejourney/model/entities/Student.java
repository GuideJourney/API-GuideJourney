package com.guidejourney.model.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileImage;
    private String name;
    private String country;
    private String school;

    @ElementCollection
    private Set<String> interests;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
