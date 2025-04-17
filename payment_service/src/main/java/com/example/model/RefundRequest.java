package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "refund_requests")
public class RefundRequest {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  public Long getId() {
    return id;
}
  public void setId(Long id) {
    this.id = id;
  }
  private Long orderId;
  public Long getOrderId() {
    return orderId;
}
  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
  private String reason;
  public String getReason() {
    return reason;
}
  public void setReason(String reason) {
    this.reason = reason;
  }
  private String status;       // REQUESTED, APPROVED, REJECTED
  public String getStatus() {
    return status;
}
  public void setStatus(String status) {
    this.status = status;
  }
  private LocalDateTime requestAt;
  public LocalDateTime getRequestAt() {
    return requestAt;
  }
  public void setRequestAt(LocalDateTime requestAt) {
    this.requestAt = requestAt;
  }

}
