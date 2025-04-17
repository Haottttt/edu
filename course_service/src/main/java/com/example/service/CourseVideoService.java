package com.example.service;

import com.example.model.CourseVideo;
import com.example.repository.CourseVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseVideoService {
  @Autowired
  private CourseVideoRepository repo;

  public CourseVideo addVideo(CourseVideo v) {
    return repo.save(v);
  }

  public List<CourseVideo> listByCourse(Long courseId) {
    return repo.findByCourseId(courseId);
  }
}
