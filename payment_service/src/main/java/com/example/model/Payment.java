package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {
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
  private Double amount;
  public Double getAmount() {
    return amount;
}
  public void setAmount(Double amount) {
    this.amount = amount;
  }
  private String method;       // WECHAT, ALIPAY, CARD
  public String getMethod() {
    return method;
}
  public void setMethod(String method) {
    this.method = method;
  }
  private String status;       // SUCCESS, FAILED
  public String getStatus() {
    return status;
}
  public void setStatus(String status) {
    this.status = status;
  }
  private LocalDateTime paidAt;
  public LocalDateTime getPaidAt() {
    return paidAt;
  }
  public void setPaidAt(LocalDateTime paidAt) {
    this.paidAt = paidAt;
  }

}
