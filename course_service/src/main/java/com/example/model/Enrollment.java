package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {
  @Id @GeneratedValue
  private Long id;
  public Long getId() {
    return id;
}
  public void setId(Long id) {
    this.id = id;
  }
  private Long studentId;
  public Long getStudentId() {
    return studentId;
}
  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }
  private Long courseId;
  public Long getCourseId() {
    return courseId;
}
  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }
  private LocalDateTime enrolledAt;
  public LocalDateTime getEnrolledAt() {
    return enrolledAt;
  }
  public void setEnrolledAt(LocalDateTime enrolledAt) {
    this.enrolledAt = enrolledAt;
  }
}

