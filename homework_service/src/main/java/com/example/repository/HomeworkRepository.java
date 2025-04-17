package com.example.repository;

import com.example.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
  List<Homework> findByStudentId(Long studentId);
  List<Homework> findByCourseId(Long courseId);
}
