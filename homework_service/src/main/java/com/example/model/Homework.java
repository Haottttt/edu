package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Homework {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  public String getDescription() {
    return description;
}
  public void setDescription(String description) {
    this.description = description;
  }
  private String description;
  private LocalDateTime submitTime;
  public LocalDateTime getSubmitTime() {
    return submitTime;
}
  public void setSubmitTime(LocalDateTime submitTime) {
    this.submitTime = submitTime;
  }
  private Boolean corrected;
  public void setCorrected(Boolean corrected) {
    this.corrected = corrected;
}
  public Boolean getCorrected() {
    return corrected;
}
  private Integer grade;
  public Integer getGrade() {
    return grade;
}
  public void setGrade(Integer grade) {
    this.grade = grade;
  }
  private String feedback;
  public String getFeedback() {
    return feedback;
  }
  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

}
