package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
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
  private Double amount;
  public Double getAmount() {
    return amount;
}
  public void setAmount(Double amount) {
    this.amount = amount;
  }
  private String status;       // PENDING, PAID, CANCELED, REFUNDED
  public String getStatus() {
    return status;
}
  public void setStatus(String status) {
    this.status = status;
  }
  private LocalDateTime createdAt;
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
