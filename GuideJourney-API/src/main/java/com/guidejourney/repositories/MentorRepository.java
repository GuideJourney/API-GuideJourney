package com.guidejourney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guidejourney.model.entities.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
