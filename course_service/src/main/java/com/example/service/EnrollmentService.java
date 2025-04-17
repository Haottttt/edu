package com.example.service;

import com.example.model.Enrollment;
import com.example.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {
  @Autowired
  private EnrollmentRepository repo;

  public Enrollment enroll(Long studentId, Long courseId) {
    Enrollment e = new Enrollment();
    e.setStudentId(studentId);
    e.setCourseId(courseId);
    e.setEnrolledAt(LocalDateTime.now());
    return repo.save(e);
  }

  public List<Enrollment> listByStudent(Long studentId) {
    return repo.findByStudentId(studentId);
  }
}

