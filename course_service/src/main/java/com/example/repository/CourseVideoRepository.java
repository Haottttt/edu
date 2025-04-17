package com.example.repository;

import java.util.List;

import com.example.model.CourseVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseVideoRepository extends JpaRepository<CourseVideo, Long> {
  List<CourseVideo> findByCourseId(Long courseId);
}