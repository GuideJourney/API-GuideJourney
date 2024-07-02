package com.guidejourney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guidejourney.model.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
