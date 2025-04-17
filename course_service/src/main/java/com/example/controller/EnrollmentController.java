package com.example.controller;


import com.example.model.Enrollment;
import com.example.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enroll")
public class EnrollmentController {
  @Autowired
  private EnrollmentService service;

  @PostMapping("/")
  public Enrollment enroll(@RequestParam Long studentId,
                           @RequestParam Long courseId) {
    return service.enroll(studentId, courseId);
  }

  @GetMapping("/student/{sid}")
  public List<Enrollment> byStudent(@PathVariable("sid") Long sid) {
    return service.listByStudent(sid);
  }
}
